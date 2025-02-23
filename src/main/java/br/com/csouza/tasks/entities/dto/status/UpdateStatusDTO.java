package br.com.csouza.tasks.entities.dto.status;

import br.com.csouza.tasks.entities.Status;
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
public class UpdateStatusDTO extends DTO<Status>{
	private String name;
	
	@Override
	public Status toEntity() {
		return Status
				.builder()
				.name(this.name)
				.build();
	}

}
