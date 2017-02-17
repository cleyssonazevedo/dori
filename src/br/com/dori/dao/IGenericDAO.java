package br.com.dori.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

@Repository
public interface IGenericDAO<T, ID extends Serializable> {
	/**
	 * M�todo padr�o para inser��o
	 * 
	 * @param entity Objeto que ser� inserido
	 * @return Retorna o objeto inserida com o ID atualizado
	 * @throws Exception Em caso de erros em geral
	 */
	public T Insert(T entity) throws Exception;
	/**
	 * M�todo padr�o para altera��o
	 * @param entity Objeto que ser� alterada
	 * @return O objeto alterado
	 * @throws Exception Em caso de erros em geral
	 */
	public T Update(T entity) throws Exception;
	/**
	 * M�todo padr�o para dele��o
	 * @param entity Objeto que ser� deletado
	 * @throws Exception Em caso de erros em geral
	 */
	public void Delete(T entity) throws Exception;
	/**
	 * M�todo padr�o para busca de um objeto
	 * @param id Id do item no banco de dados
	 * @return O objeto com o ID
	 * @throws NoResultException Em caso de n�o ter o item com este ID
	 * @throws Exception Em caso de erro em geral
	 */
	public T Find(ID id) throws NoResultException, Exception;
	/**
	 * M�todo padr�o para busca de todos os objetos na tabela
	 * @return Lista com todos os objetos
	 * @throws NoResultException Caso n�o tenha itens no banco de dados
	 * @throws Exception Em caso de erros em geral
	 */
	public List<T> FindAll() throws NoResultException, Exception;
}
