package br.com.csouza.tasks.services;

import java.util.Objects;

import br.com.csouza.tasks.entities.Task;
import br.com.csouza.tasks.interfaces.repositories.ITaskRepository;

@org.springframework.stereotype.Service
public class TaskService extends Service<Task>{
	public TaskService(ITaskRepository repository) {
		super(repository);
	}

	@Override
	protected Task updatedFields(Task entity, Task data) {
		entity.setTitle(data.getTitle() == null || data.getTitle().isEmpty() ? entity.getTitle() : data.getTitle());
		entity.setDescription(data.getDescription() == null || data.getDescription().isEmpty() ? entity.getDescription() : data.getDescription());
		entity.setFinished(Objects.equals(data.isFinished(), null) ? entity.isFinished() : data.isFinished());
		
		return entity;
	}
}
