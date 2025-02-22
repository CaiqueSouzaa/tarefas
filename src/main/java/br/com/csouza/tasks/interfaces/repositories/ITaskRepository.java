package br.com.csouza.tasks.interfaces.repositories;

import org.springframework.stereotype.Repository;

import br.com.csouza.tasks.entities.Task;

/**
 * Repositorio da entidade Task.
 * 
 * @author Caique Souza
 * @version 0.1
 */
@Repository()
public interface ITaskRepository extends IRepository<Task> {
}
