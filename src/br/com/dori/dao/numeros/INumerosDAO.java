package br.com.dori.dao.numeros;

import org.springframework.stereotype.Repository;

import br.com.dori.dao.IGenericDAO;
import br.com.dori.entities.Numeros;

@Repository
public interface INumerosDAO extends IGenericDAO<Numeros, Long> {
	
}