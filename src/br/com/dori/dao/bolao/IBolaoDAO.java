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
	 * @return Bolão finalizado
	 * @throws Exception
	 */
	void Finally(Bolao bolao) throws Exception;

	Bolao Active() throws Exception;

	/**
	 * Método para retorno de um bolão de acordo com o seu ID, já faz o
	 * tratamento do NoResultException, retornando null
	 * 
	 * @return Bolão cadastrado
	 * @exception Exception Em caso de erros em geral
	 */
	@Override
	Bolao Find(Long id) throws Exception;

	/**
	 * Método para retorno de todos os bolões já cadastrados, já faz o
	 * tratamento do NoResultException, retornando null
	 * 
	 * @return Lista com todos os bolões
	 * @exception NoResultException Caso não exista bolões cadastrados
	 * @exception Exception Em caso de erros em geral
	 */
	@Override
	List<Bolao> FindAll() throws Exception;
}