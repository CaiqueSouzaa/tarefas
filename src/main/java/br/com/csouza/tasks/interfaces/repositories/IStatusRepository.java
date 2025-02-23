package br.com.csouza.tasks.interfaces.repositories;

import org.springframework.stereotype.Repository;

import br.com.csouza.tasks.entities.Status;

/**
 * Interface responsável por fornecer os métodos de repositório da entidade Status.
 * 
 * @author Caique Souza
 * @version 0.1
 */
@Repository
public interface IStatusRepository extends IRepository<Status> {
	Status findByName(String name);
}
