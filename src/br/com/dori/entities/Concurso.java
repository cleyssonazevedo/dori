package br.com.dori.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Entity implementation class for Entity: Concurso
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "unique_name"))
public class Concurso implements Serializable {
	private static final long serialVersionUID = 1797890058250179774L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, updatable = false)
	private String name;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_numeros", foreignKey = @ForeignKey(name = "fk_numeros_concurso"), nullable = false, updatable = false)
	private Numeros numeros;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_bolao", foreignKey = @ForeignKey(name = "fk_bolao_concurso"), nullable = false, updatable = false)
	private Bolao bolao;

	public Bolao getBolao() {
		return bolao;
	}

	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Numeros getNumeros() {
		return numeros;
	}

	public void setNumeros(Numeros numeros) {
		this.numeros = numeros;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}