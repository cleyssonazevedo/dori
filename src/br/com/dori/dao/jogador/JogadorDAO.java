package br.com.dori.dao.jogador;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.dori.dao.GenericDAO;
import br.com.dori.entities.Jogador;

@Component
public class JogadorDAO extends GenericDAO<Jogador, Long> implements IJogadorDAO {

	public JogadorDAO() {
		// TODO Auto-generated constructor stub
		super(Jogador.class);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Jogador Find(Long id) throws NoResultException, Exception {
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
	public List<Jogador> FindAll(long id) throws Exception {
		// TODO Auto-generated method stub
		try {
			CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Jogador> criteria = builder.createQuery(Jogador.class);
			Root<Jogador> root = criteria.from(Jogador.class);
			criteria.select(root).where(builder.equal(root.get("bolao").get("id"), id));

			TypedQuery<Jogador> query = super.getEntityManager().createQuery(criteria);

			return query.getResultList();
		} catch (NullPointerException e) {
			// TODO: handle exception
			return null;
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
