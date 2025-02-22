package br.com.csouza.tasks.interfaces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.csouza.tasks.entities.DatabaseEntity;

/**
 * Interface de repositório que todos os repositórios devem implementar.
 * @param <T> Tipo de entidade que será ser manipulada pelo repositorio.
 */
public interface IRepository<T extends DatabaseEntity> extends JpaRepository<T, Long> {}
