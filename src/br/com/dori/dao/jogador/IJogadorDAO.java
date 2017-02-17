package br.com.dori.dao.jogador;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.dori.dao.IGenericDAO;
import br.com.dori.entities.Jogador;

@Repository
public interface IJogadorDAO extends IGenericDAO<Jogador, Long> {
	/**
	 * Método de busca de um jogador, já implementado 
	 * returno null em caso de {@link NoResultException}
	 * @param id Id do Jogador
	 * @return Jogador com este ID 
	 */
	@Override
	Jogador Find(Long id) throws Exception;

	/**
	 * Método para busca de jogadores de um bolão
	 * @param bolao Bolão no qual os jogadores participam
	 * @return Lista com todos os jogadores do bolão
	 * @throws Exception Em caso de erros em geral
	 */
	List<Jogador> FindAll(long id) throws Exception;
}
