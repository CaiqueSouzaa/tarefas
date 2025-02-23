package br.com.csouza.tasks.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe abstrata base que todas as entidades do banco de dados devem extender.
 * 
 * @author Caique Souza
 * @version 0.1
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass()
public abstract class DatabaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "created_at", nullable = false)
	protected Instant createdAt;
	
	@Column(name = "updated_at", nullable = false)
	protected Instant updatedAt;
	
	@PrePersist()
	protected void prePersist() {
		this.createdAt = Instant.now();
	}
	
	@PreUpdate()
	protected void preUpdate() {
		this.updatedAt = Instant.now();
	}
}
