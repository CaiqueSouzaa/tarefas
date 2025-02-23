package br.com.csouza.tasks.entities.dto.task;

import java.util.Objects;

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
@Builder
public class StoreTaskDTO extends DTO<Task>{
	private String title;
	private String description;
	private long status_id;
	private boolean finished;

	@Override
	public Task toEntity() {
		final Status status = Status
				.builder()
				.id(status_id)
				.build();
		
		return Task
				.builder()
				.title(this.title)
				.description(this.description)
				.finished(Objects.equals(this.finished, null) ? false : this.finished)
				.status(status)
				.build();
	}

}
