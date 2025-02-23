package br.com.csouza.tasks.interfaces.services;

import br.com.csouza.tasks.entities.Status;

/**
 * Interface responsável por fornecer os métodos de serviço da entidade Status.
 * 
 * @author Caique Souza
 * @version 0.1
 */
public interface IStatusService extends IService<Status> {
	Status findByName(String name);
}
