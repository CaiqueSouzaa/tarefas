package br.com.csouza.tasks.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import br.com.csouza.tasks.entities.DatabaseEntity;
import br.com.csouza.tasks.entities.dto.DTO;
import br.com.csouza.tasks.exceptions.RegisterIDNotFoundException;
import br.com.csouza.tasks.interfaces.repositories.IRepository;
import br.com.csouza.tasks.interfaces.services.IService;

/**
 * Classe abstrata contendo a implementação de IService.
 * @param <T> Tipo da entidade a ser manipulada pelo serviço.
 * 
 * @author Caique Souza
 * @version 0.1
 */
public abstract class Service<T extends DatabaseEntity> implements IService<T> {
	protected IRepository<T> repository;
	
	public Service(IRepository<T> repository) {
		this.repository = repository;
	}

	@Override
	public T store(DTO<T> entity) {
		return this.repository.save(entity.toEntity());
	}

	@Override
	public Page<T> index(int page, int size) {
		final PageRequest pageRequest = PageRequest.of(page, size, Direction.ASC, "id");
		
		return this.repository.findAll(pageRequest);
	}

	@Override
	public T show(long id) {
		Optional<T> entity = this.repository.findById(id);
		
		if (entity.isEmpty()) {
			throw new RegisterIDNotFoundException(id);
		}
		
		return entity.get();
	}

	@Override
	public T update(long id, DTO<T> data) {
		final T storagedEntity = this.show(id);
		
		final T entity = this.updatedFields(storagedEntity, data.toEntity());
		
		this.repository.save(entity);
		
		return entity;
	}
	
	/**
	 * Método para adicionar os novos valores a entidade já registrada no banco de dados.
	 * @param entity Entidade requisitada do banco de dados contendo todas as informações originais do registro.
	 * @param data Novas informações a serem inseridas na entidade.
	 * @return Entidade contendo as novas informações.
	 */
	protected abstract T updatedFields(T entity, T data);

	@Override
	public void destroy(long id) {
		this.show(id);
		
		this.repository.deleteById(id);
	}
}
