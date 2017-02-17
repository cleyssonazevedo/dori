package br.com.dori.dao.jogador;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.dori.dao.IGenericDAO;
import br.com.dori.entities.Jogador;

@Repository
public interface IJogadorDAO extends IGenericDAO<Jogador, Long> {
	/**
	 * M�todo de busca de um jogador, j� implementado 
	 * returno null em caso de {@link NoResultException}
	 * @param id Id do Jogador
	 * @return Jogador com este ID 
	 */
	@Override
	Jogador Find(Long id) throws Exception;

	/**
	 * M�todo para busca de jogadores de um bol�o
	 * @param bolao Bol�o no qual os jogadores participam
	 * @return Lista com todos os jogadores do bol�o
	 * @throws Exception Em caso de erros em geral
	 */
	List<Jogador> FindAll(long id) throws Exception;
}
