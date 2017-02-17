package br.com.dori.entities;

import java.io.Serializable;
import javax.persistence.*;

import br.com.dori.exceptions.NotValidException;

/**
 * Entity implementation class for Entity: Numeros
 *
 */
@Entity
public class Numeros implements Serializable {
	private static final long serialVersionUID = 6018654309607799180L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "CHAR(2) NOT NULL", updatable = false)
	private String num1;
	@Column(columnDefinition = "CHAR(2) NOT NULL", updatable = false)
	private String num2;
	@Column(columnDefinition = "CHAR(2) NOT NULL", updatable = false)
	private String num3;
	@Column(columnDefinition = "CHAR(2) NOT NULL", updatable = false)
	private String num4;
	@Column(columnDefinition = "CHAR(2) NOT NULL", updatable = false)
	private String num5;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNum1() {
		return num1;
	}

	public String getNum2() {
		return num2;
	}

	public String getNum3() {
		return num3;
	}

	public String getNum4() {
		return num4;
	}

	public String getNum5() {
		return num5;
	}

	public void setNum1(Integer num1) throws NotValidException {
		if (num1 > 0 && num1 < 10) {
			this.num1 = "0" + num1;
		} else if (num1 > 10 && num1 < 100)
			this.num1 = num1.toString();
		else
			throw new NotValidException();
	}

	public void setNum2(Integer num2) throws NotValidException {
		if (num2 > 0 && num2 < 10) {
			this.num2 = "0" + num2;
		} else if (num2 >= 10 && num2 < 100)
			this.num2 = num2.toString();
		else
			throw new NotValidException();
	}

	public void setNum3(Integer num3) throws NotValidException {
		if (num3 > 0 && num3 < 10) {
			this.num3 = "0" + num3;
		} else if (num3 >= 10 && num3 < 100)
			this.num3 = num3.toString();
		else
			throw new NotValidException();
	}

	public void setNum4(Integer num4) throws NotValidException {
		if (num4 > 0 && num4 < 10) {
			this.num4 = "0" + num4;
		} else if (num4 >= 10 && num4 < 100)
			this.num4 = num4.toString();
		else
			throw new NotValidException();
	}

	public void setNum5(Integer num5) throws NotValidException {
		if (num5 > 0 && num5 < 10) {
			this.num5 = "0" + num5;
		} else if (num5 >= 10 && num5 < 100)
			this.num5 = num5.toString();
		else
			throw new NotValidException();
	}

}