package br.com.csouza.tasks.exceptions;

public class FindFieldException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public FindFieldException(String field, String value) {
		super("Não foi possível concluir a pesquisa de { '" + field + "': '" + value + "' }. Valor não localizado ou inexistente.");
	}
}
