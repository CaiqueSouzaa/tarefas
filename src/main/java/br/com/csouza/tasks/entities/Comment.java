package br.com.csouza.tasks.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade de comentários, Comments.
 * 
 * @author Caique Souza
 * @version 0.1
 */
@Entity()
@Table(name = "tb_comments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment extends DatabaseEntity {
	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tasks")
	@SequenceGenerator(name = "sq_tasks", sequenceName = "sq_id_tasks", initialValue = 1, allocationSize = 1)
	private long id;
	
	@Column(nullable = false)
	private String comment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name = "id_task",
			foreignKey = @ForeignKey(
				name = "fk_id_tasks"
			),
			nullable = false
	)
	private Task task;
}
