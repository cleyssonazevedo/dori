package br.com.dori.exceptions;

public class NotValidException extends Exception {
	private static final long serialVersionUID = -6537083905829483987L;

	public NotValidException() {
		// TODO Auto-generated constructor stub
		super("Somente podem ser inseridos números entre 1 e 99!");
	}
}
