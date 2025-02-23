package br.com.csouza.tasks.exceptions;

/**
 * Exceção para o caso de algum campo da entidade não ser válido.
 * 
 * @author Caique Souza
 * @version 0.1
 */
public class InvalidFieldException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidFieldException(String msg) {
		super(msg);
	}
}
