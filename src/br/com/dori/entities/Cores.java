package br.com.dori.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cores
 *
 */
@Entity
public class Cores implements Serializable {
	private static final long serialVersionUID = 5035409539055561528L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "CHAR(6) NOT NULL", updatable = false)
	private String color1;
	@Column(columnDefinition = "CHAR(6) NOT NULL", updatable = false)
	private String color2;
	@Column(columnDefinition = "CHAR(6) NOT NULL", updatable = false)
	private String color3;
	@Column(columnDefinition = "CHAR(6) NOT NULL", updatable = false)
	private String color4;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}

	public String getColor3() {
		return color3;
	}

	public void setColor3(String color3) {
		this.color3 = color3;
	}

	public String getColor4() {
		return color4;
	}

	public void setColor4(String color4) {
		this.color4 = color4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}