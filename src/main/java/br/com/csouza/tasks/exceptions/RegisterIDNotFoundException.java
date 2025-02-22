package br.com.csouza.tasks.exceptions;

/**
 * Exceção para o caso de o ID de registro informado não existir.
 * 
 * @author Caique Souza
 * @version 0.1
 */
public class RegisterIDNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RegisterIDNotFoundException(long id) {
		super("ID [" + id + "] não localizado ou inexistente.");
	}
}
