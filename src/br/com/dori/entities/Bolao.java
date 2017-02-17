package br.com.dori.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Entity implementation class for Entity: Bolao
 *
 */
@Entity
public class Bolao implements Serializable {
	private static final long serialVersionUID = -5722688988502150396L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date start;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(insertable = true, updatable = false)
	private Date end;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "id_colors", foreignKey = @ForeignKey(name = "fk_colors_bolao"))
	private Cores colors;

	public Cores getColors() {
		return colors;
	}

	public void setColors(Cores colors) {
		this.colors = colors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
