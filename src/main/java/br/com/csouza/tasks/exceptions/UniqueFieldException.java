package br.com.csouza.tasks.exceptions;

public class UniqueFieldException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UniqueFieldException(String value) {
		super("O valor [" + value + "] não está disponível para uso.");
	}
}
