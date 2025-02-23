package br.com.csouza.tasks.entities;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "tb_status")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status extends DatabaseEntity {
	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_status")
	@SequenceGenerator(name = "sq_status", sequenceName = "sq_id_status", initialValue = 1, allocationSize = 1)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany()
	private List<Task> tasks;
	
	@PrePersist()
	protected void prePersist() {
		this.createdAt = Instant.now();
		this.updatedAt = Instant.now();
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + ", tasks=" + tasks + "]";
	}
}
