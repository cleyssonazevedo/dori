package br.com.dori.dao.concurso;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dori.dao.IGenericDAO;
import br.com.dori.entities.Concurso;

@Repository
public interface IConcursoDAO extends IGenericDAO<Concurso, Long> {	
	/**
	 * M�todo para busca de concurso de um bol�o
	 * @param id_bolao ID do bol�o
	 * @return Lista com todos os concursos deste bol�o
	 * @throws Exception
	 */
	List<Concurso> FindAll(long id_bolao) throws Exception;
}