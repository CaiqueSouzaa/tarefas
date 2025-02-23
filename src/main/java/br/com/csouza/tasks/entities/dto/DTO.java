package br.com.csouza.tasks.entities.dto;

import br.com.csouza.tasks.entities.DatabaseEntity;

/**
 * Classe abstrata responsável por fornecer o método "toEntity" que deve ser implementado em todos os DTOs.
 * @param <T> Tipo de entidade que será ser manipulada pelo repositorio.
 */
public abstract class DTO<T extends DatabaseEntity> {
	/**
	 * Transformar o DTO em uma entidade.
	 * @return Entidade a qual o DTO se refere.
	 */
	public abstract T toEntity();
}
