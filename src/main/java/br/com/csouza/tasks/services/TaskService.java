package br.com.csouza.tasks.services;

import java.util.Objects;

import br.com.csouza.tasks.entities.Status;
import br.com.csouza.tasks.entities.Task;
import br.com.csouza.tasks.interfaces.repositories.ITaskRepository;
import br.com.csouza.tasks.interfaces.services.ITaskService;

@org.springframework.stereotype.Service
public class TaskService extends Service<Task> implements ITaskService {
	protected StatusService statusService;
	
	public TaskService(ITaskRepository repository, StatusService statusService) {
		super(repository);
		this.statusService = statusService;
	}

	@Override
	protected Task updatedFields(Task entity, Task data) {
		entity.setTitle(data.getTitle() == null || data.getTitle().isEmpty() ? entity.getTitle() : data.getTitle());
		entity.setDescription(data.getDescription() == null || data.getDescription().isEmpty() ? entity.getDescription() : data.getDescription());
		entity.setStatus(data.getStatus() == null ? entity.getStatus() : data.getStatus());
		entity.setFinished(Objects.equals(data.isFinished(), null) ? entity.isFinished() : data.isFinished());
		
		return entity;
	}

	@Override
	protected void isValidStore(Task entity) {
		if (entity.getStatus() == null || entity.getStatus().getId() == 0) {
			return;
		}
		
		final Status status = this.statusService.show(entity.getStatus().getId());
		
		entity.setStatus(status);
	}
}
