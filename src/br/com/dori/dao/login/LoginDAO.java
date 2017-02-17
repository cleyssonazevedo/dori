package br.com.dori.dao.login;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.dori.dao.GenericDAO;
import br.com.dori.entities.Login;
import br.com.dori.exceptions.LoginExistsException;
import br.com.dori.exceptions.UnauthorizedException;

@Component
public class LoginDAO extends GenericDAO<Login, Long> implements ILoginDAO {
	public LoginDAO() {
		// TODO Auto-generated constructor stub
		super(Login.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Login Logar(Login login) throws UnauthorizedException, Exception {
		// TODO Auto-generated method stub
		try {
			login = Encrypt(login);
			
			CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Login> criteria = builder.createQuery(Login.class);
			Root<Login> root = criteria.from(Login.class);
			criteria.select(root)
			.where(
				builder.and(
					builder.equal(root.get("username"), login.getUsername()),
					builder.equal(root.get("password"), login.getPassword())
				)
			);
			
			TypedQuery<Login> query = super.getEntityManager().createQuery(criteria);

			return query.getSingleResult();
		} catch (NoResultException ue) {
			// TODO: handle exception
			throw new UnauthorizedException();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	@Transactional
	public Login Insert(Login login) throws Exception {
		// TODO Auto-generated method stub
		if (Logar(login) == null) {
			try {
				super.Insert(Encrypt(login));
				return login;
			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}
		} else
			throw new LoginExistsException();
	}

	@Override
	@Transactional
	public Login Update(Login login) throws Exception {
		// TODO Auto-generated method stub
		try {
			return super.Update(Encrypt(login));
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	@Override
	@Transactional
	public void Delete(Login login) throws Exception {
		try {
			super.Delete(Encrypt(login));
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public Login Encrypt(Login login) throws Exception {
		// TODO Auto-generated method stub
		return login;
	}
}
