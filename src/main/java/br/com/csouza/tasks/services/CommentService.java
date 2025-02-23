package br.com.csouza.tasks.services;

import br.com.csouza.tasks.entities.Comment;
import br.com.csouza.tasks.exceptions.InvalidFieldException;
import br.com.csouza.tasks.interfaces.repositories.ICommentRepository;
import br.com.csouza.tasks.interfaces.services.ICommentService;

public class CommentService extends Service<Comment> implements ICommentService {
	private ICommentRepository commentRepository;
	
	public CommentService(ICommentRepository commentRepository) {
		super(commentRepository);
		this.commentRepository = commentRepository;
	}

	@Override
	protected void isValidStore(Comment entity) {
		if (entity.getComment() == null || entity.getComment().isEmpty()) {
			throw new InvalidFieldException("A propriedade [ comment ] deve obrigatoriamente possuir valor.");
		}
	}

	@Override
	protected Comment updatedFields(Comment entity, Comment data) {
		// TODO Auto-generated method stub
		return null;
	}
}
