package br.com.csouza.tasks.interfaces.repositories;

import org.springframework.stereotype.Repository;

import br.com.csouza.tasks.entities.Comment;

/**
 * Interface responsável por fornecer os métodos de repositório da entidade Comment.
 * 
 * @author Caique Souza
 * @version 0.1
 */
@Repository
public interface ICommentRepository extends IRepository<Comment> {
}
