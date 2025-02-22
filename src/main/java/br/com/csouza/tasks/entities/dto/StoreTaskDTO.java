package br.com.csouza.tasks.entities.dto;

import br.com.csouza.tasks.entities.Task;
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

	@Override
	public Task toEntity() {
		return Task
				.builder()
				.title(this.title)
				.description(this.description)
				.build();
	}

}
