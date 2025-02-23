package br.com.csouza.tasks.entities;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade de tarefas, Task.
 * 
 * @author Caique Souza
 * @version 0.1
 */
@Entity()
@Table(name = "tb_tasks")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task extends DatabaseEntity {
	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tasks")
	@SequenceGenerator(name = "sq_tasks", sequenceName = "sq_id_tasks", initialValue = 1, allocationSize = 1)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	private boolean finished;
	
	@ManyToOne()
	@JoinColumn(
			name = "id_status",
			foreignKey = @ForeignKey(
					name = "fk_id_status"
			),
			nullable = true
	)
	private Status status;
	
	@OneToMany(mappedBy = "task")
	private Set<Comment> comments;
	
	@PrePersist()
	protected void prePersist() {
		this.finished = false;
		this.createdAt = Instant.now();
		this.updatedAt = Instant.now();
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", finished=" + finished
				+ ", status=" + status + ", comments=" + comments + "]";
	}
}
