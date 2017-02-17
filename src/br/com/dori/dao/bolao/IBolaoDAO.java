package br.com.dori.dao.bolao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.dori.dao.IGenericDAO;
import br.com.dori.entities.Bolao;

@Repository
public interface IBolaoDAO extends IGenericDAO<Bolao, Long> {
	Bolao Insert() throws Exception;

	/**
	 * Update end
	 * 
	 * @param bolao
	 * @return Bol�o finalizado
	 * @throws Exception
	 */
	void Finally(Bolao bolao) throws Exception;

	Bolao Active() throws Exception;

	/**
	 * M�todo para retorno de um bol�o de acordo com o seu ID, j� faz o
	 * tratamento do NoResultException, retornando null
	 * 
	 * @return Bol�o cadastrado
	 * @exception Exception Em caso de erros em geral
	 */
	@Override
	Bolao Find(Long id) throws Exception;

	/**
	 * M�todo para retorno de todos os bol�es j� cadastrados, j� faz o
	 * tratamento do NoResultException, retornando null
	 * 
	 * @return Lista com todos os bol�es
	 * @exception NoResultException Caso n�o exista bol�es cadastrados
	 * @exception Exception Em caso de erros em geral
	 */
	@Override
	List<Bolao> FindAll() throws Exception;
}