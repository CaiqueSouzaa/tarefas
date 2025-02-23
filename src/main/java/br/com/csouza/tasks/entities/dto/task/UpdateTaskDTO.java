package br.com.csouza.tasks.entities.dto.task;

import br.com.csouza.tasks.entities.Status;
import br.com.csouza.tasks.entities.Task;
import br.com.csouza.tasks.entities.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder()
public class UpdateTaskDTO extends DTO<Task> {
	private String title;
	private String description;
	private long status_id;
	private boolean finished;
	
	@Override
	public Task toEntity() {
		final Status status = Status
				.builder()
				.id(this.status_id)
				.build();
		
		return Task
				.builder()
				.title(this.title)
				.description(this.description)
				.status(status)
				.finished(this.finished)
				.build();
	}

}
