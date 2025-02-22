package br.com.csouza.tasks.entities.dto;

import br.com.csouza.tasks.entities.DatabaseEntity;

public abstract class DTO<T extends DatabaseEntity> {
	public abstract T toEntity();
}
