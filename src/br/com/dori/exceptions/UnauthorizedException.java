package br.com.dori.exceptions;

public class UnauthorizedException extends Exception {
	private static final long serialVersionUID = -8709647826719716696L;
	private static final String MESSAGE = "Usuário ou senha incorretos!";

	public UnauthorizedException() {
		// TODO Auto-generated constructor stub
		super(MESSAGE);
	}
	
	public UnauthorizedException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	

	public UnauthorizedException(Throwable cause) {
		super(MESSAGE, cause);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}