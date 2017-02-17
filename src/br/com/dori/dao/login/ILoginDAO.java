package br.com.dori.dao.login;

import org.springframework.stereotype.Repository;

import br.com.dori.dao.IGenericDAO;
import br.com.dori.entities.Login;
import br.com.dori.exceptions.LoginExistsException;
import br.com.dori.exceptions.UnauthorizedException;

@Repository
public interface ILoginDAO extends IGenericDAO<Login, Long> {
	/**
	 * M�todo para logar no sistema
	 * 
	 * @param login
	 * @return Retorna o login criptografado
	 * @throws UnauthorizedException Em caso de login inv�lido
	 * @throws Exception Em caso de erros sem tratamento
	 */
	Login Logar(Login login) throws UnauthorizedException, Exception;
	
	/**
	 * M�todo para inser��o de login no sistema
	 * @param login Objeto que ser� gravado no banco
	 * @return Login inserido, este ter� o ID e j� deve estar criptografado
	 * @exception LoginExistsException Caso ja tenha um login cadastrado no sistema
	 * @exception Exception Em caso de erros em geral
	 */
	@Override
	Login Insert(Login login) throws LoginExistsException, Exception;
	
	@Override
	Login Update(Login login) throws Exception;
	
	@Override
	void Delete(Login login) throws Exception;
	
	/**
	 * M�todo para criptografia de dados no banco de dados
	 * @param login Login a ser criptografado
	 * @return	Login criptografado
	 * @throws Exception Em caso de erro quando tentar criptografar
	 */
	Login Encrypt(Login login) throws Exception;
}
