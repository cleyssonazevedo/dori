package br.com.dori.dao.bolao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.dori.dao.GenericDAO;
import br.com.dori.entities.Bolao;
import br.com.dori.exceptions.BolaoException;

@Component
public class BolaoDAO extends GenericDAO<Bolao, Long> implements IBolaoDAO {
	public BolaoDAO() {
		// TODO Auto-generated constructor stub
		super(Bolao.class);
	}

	@Override
	@Transactional
	public Bolao Insert() throws Exception {
		// TODO Auto-generated method stub
		try {
			if (Active() == null) {
				Bolao bolao = new Bolao();
				bolao.setStart(new Date());

				return super.Insert(bolao);
			} else
				throw new BolaoException("Já Existe um bolão em andamento!");
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	@Transactional
	public void Finally(Bolao bolao) throws Exception {
		// TODO Auto-generated method stub
		try {
			bolao.setEnd(new Date());
			super.Update(bolao);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Bolao Active() throws Exception {
		// TODO Auto-generated method stub
		try {
			CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Bolao> criteria = builder.createQuery(Bolao.class);
			Root<Bolao> root = criteria.from(Bolao.class);
			criteria.select(root).where(builder.isNull(root.get("end")));
			TypedQuery<Bolao> query = super.getEntityManager().createQuery(criteria);

			return query.getResultList().get(query.getFirstResult());
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			return null;
		} catch (NullPointerException e) {
			// TODO: handle exception
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Bolao Find(Long id) throws Exception {
		// TODO Auto-generated method stub
		try {
			return super.Find(id);
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bolao> FindAll() throws Exception {
		// TODO Auto-generated method stub
		try {
			return super.FindAll();
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
}
