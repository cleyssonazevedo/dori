package br.com.dori.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Login
 *
 */
@Entity
public class Login implements Serializable {
	private static final long serialVersionUID = -8440538162487971209L;

	@Id
	@Column(columnDefinition = "VARCHAR(255) BINARY UNIQUE")
	private String username;
	@Column(columnDefinition = "VARCHAR(255) BINARY NOT NULL")
	private String password;

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}