package br.com.dori.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

@Repository
public interface IGenericDAO<T, ID extends Serializable> {
	/**
	 * Método padrão para inserção
	 * 
	 * @param entity Objeto que será inserido
	 * @return Retorna o objeto inserida com o ID atualizado
	 * @throws Exception Em caso de erros em geral
	 */
	public T Insert(T entity) throws Exception;
	/**
	 * Método padrão para alteração
	 * @param entity Objeto que será alterada
	 * @return O objeto alterado
	 * @throws Exception Em caso de erros em geral
	 */
	public T Update(T entity) throws Exception;
	/**
	 * Método padrão para deleção
	 * @param entity Objeto que será deletado
	 * @throws Exception Em caso de erros em geral
	 */
	public void Delete(T entity) throws Exception;
	/**
	 * Método padrão para busca de um objeto
	 * @param id Id do item no banco de dados
	 * @return O objeto com o ID
	 * @throws NoResultException Em caso de não ter o item com este ID
	 * @throws Exception Em caso de erro em geral
	 */
	public T Find(ID id) throws NoResultException, Exception;
	/**
	 * Método padrão para busca de todos os objetos na tabela
	 * @return Lista com todos os objetos
	 * @throws NoResultException Caso não tenha itens no banco de dados
	 * @throws Exception Em caso de erros em geral
	 */
	public List<T> FindAll() throws NoResultException, Exception;
}
