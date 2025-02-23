package br.com.csouza.tasks.entities.dto.comment;

import br.com.csouza.tasks.entities.Comment;
import br.com.csouza.tasks.entities.Task;
import br.com.csouza.tasks.entities.dto.DTO;

public class StoreCommentDTO extends DTO<Comment> {
	private String comment;
	private long task_id;
	
	@Override
	public Comment toEntity() {
		final Task task = Task
				.builder()
				.id(this.task_id)
				.build();
		
		return Comment
				.builder()
				.comment(this.comment)
				.task(task)
				.build();
	}
}
