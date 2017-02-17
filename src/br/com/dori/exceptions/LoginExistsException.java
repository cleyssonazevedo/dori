package br.com.dori.exceptions;

public class LoginExistsException extends Exception {
	private static final long serialVersionUID = 5582931413933074251L;
	private static final String MESSAGE = "Login já cadastrado no sistema!";

	public LoginExistsException() {
		// TODO Auto-generated constructor stub
		super(MESSAGE);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}