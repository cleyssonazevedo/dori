package br.com.dori.dao.concurso;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.dori.dao.GenericDAO;
import br.com.dori.entities.Concurso;

@Component
public class ConcursoDAO extends GenericDAO<Concurso, Long> implements IConcursoDAO {
	public ConcursoDAO() {
		// TODO Auto-generated constructor stub
		super(Concurso.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Concurso> FindAll(long id_bolao) throws Exception {
		// TODO Auto-generated method stub
		try {
			CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Concurso> criteria = builder.createQuery(Concurso.class);
			Root<Concurso> root = criteria.from(Concurso.class);
			criteria.select(root).where(builder.equal(root.get("bolao").get("id"), id_bolao));
			TypedQuery<Concurso> query = super.getEntityManager().createQuery(criteria);

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
