package br.com.csouza.tasks.services;

import br.com.csouza.tasks.entities.Status;
import br.com.csouza.tasks.exceptions.FindFieldException;
import br.com.csouza.tasks.exceptions.UniqueFieldException;
import br.com.csouza.tasks.interfaces.repositories.IStatusRepository;
import br.com.csouza.tasks.interfaces.services.IStatusService;

@org.springframework.stereotype.Service
public class StatusService extends Service<Status> implements IStatusService {
	private IStatusRepository statusRepository;
	
	public StatusService(IStatusRepository statusRepository) {
		super(statusRepository);
		this.statusRepository = statusRepository;
	}

	@Override
	protected Status updatedFields(Status entity, Status data) {
		entity.setName(data.getName() == null || data.getName().isEmpty() ? entity.getName() : data.getName());
		
		return entity;
	}

	@Override
	public Status findByName(String name) {
		final Status status = this.statusRepository.findByName(name);
		
		if (status == null) {
			throw new FindFieldException("name", name);
		}
		
		return status;
	}

	@Override
	protected void isValidStore(Status entity) {
		boolean hasStatus = false;
		
		try {
			this.findByName(entity.getName());
			
			hasStatus = true;
		} catch (RuntimeException e) {
			hasStatus = false;
		}
		
		if (hasStatus) {
			throw new UniqueFieldException(entity.getName());
		}
	}
}
