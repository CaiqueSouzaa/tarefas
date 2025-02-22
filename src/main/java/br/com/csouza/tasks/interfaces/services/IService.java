package br.com.csouza.tasks.interfaces.services;

import org.springframework.data.domain.Page;

import br.com.csouza.tasks.entities.DatabaseEntity;
import br.com.csouza.tasks.entities.dto.DTO;

/**
 * Interface responsável por fornecer os métodos básicos que todos os serviços devem implementar.
 * 
 * @param <T> Tipo da entidade a ser manipulada pelo serviço.
 * 
 * @author Caique Souza
 * @version 0.1
 */
public interface IService<T extends DatabaseEntity> {
	/**
	 * Registrar a entidade.
	 * @param entity Entidade a ser registrada.
	 * @return Entidade registrada contendo seu ID único.
	 */
	public T store(DTO<T> entity);
	
	/**
	 * Obter todos os registros.
	 * @param page Número da página a ser buscada.
	 * @param size Quantia de itens por página.
	 * @return Página contendo a quatia de entidades solicitada.
	 */
	public Page<T> index(int page, int size);
	
	/**
	 * Obter um único registro com base em seu ID.
	 * @param id ID de registro a ser pesquisado.
	 * @return Entidade correspondente ao ID.
	 */
	public T show(long id);
	
	/**
	 * Atualizar um registro.
	 * @param id ID do registro a ter as informações atualizadas.
	 * @param data Entidade contendo as informações a serem atualizadas.
	 * @return Entidade contendo as novas informações atualizadas.
	 */
	public T update(long id, DTO<T> data);
	
	/**
	 * Excluir um registro.
	 * @param id ID de registro a ser excluído.
	 */
	public void destroy(long id);
}
