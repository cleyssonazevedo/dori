package br.com.dori.dao.numeros;

import org.springframework.stereotype.Component;

import br.com.dori.dao.GenericDAO;
import br.com.dori.entities.Numeros;

@Component
public class NumerosDAO extends GenericDAO<Numeros, Long> implements INumerosDAO {

	public NumerosDAO() {
		// TODO Auto-generated constructor stub
		super(Numeros.class);
	}
}
