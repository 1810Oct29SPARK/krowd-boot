package com.revature.krowdboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.CommentRepository;

/**
 * 
 * The service class that manages the communication between the DAO layer and
 * the controller layer for the Comment class.
 * 
 * @author Unknown
 *
 */
@Service("commentService")
public class CommentService {

	private CommentRepository commentRepository;

	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	public List<Comment> getCommentsByFlag(int flag) {
		return commentRepository.getCommentsByFlag(flag);
	}

	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	public Comment getCommentById(int id) {
		Optional<Comment> c = commentRepository.findById(id);
		if (c.isPresent()) {
			return c.get();
		} else {
			return null;
		}
	}

	/**
	 * 
	 * The method that deletes a comment by its ID.
	 * 
	 * @param id
	 */
	public void deleteCommentById(int id) {
		commentRepository.deleteById(id);
	}

	/**
	 * 
	 * The method that creates and posts a new comment.
	 * 
	 * @param comment
	 * @return the comment
	 */
	public Comment createAComment(Comment comment) {
		return commentRepository.save(comment);
	}

	/**
	 * 
	 * The method that updates a comment.
	 * 
	 * @param comment
	 * @return the updated comment
	 */
	public Comment updateComment(Comment comment) {
		return commentRepository.save(comment);
	}

	/**
	 * 
	 * The method that retrieves and returns all comments posted by a specific user.
	 * 
	 * @param userId
	 * @return the comment list
	 */
	public List<Comment> getByUser(int userId) {
		return commentRepository.findByUserId(new User(userId));
	}

	/**
	 * 
	 * The methods that retrieves and returns all comments posted on a specific
	 * event.
	 * 
	 * @param eventId
	 * @return the comment list
	 */
	public List<Comment> getByEvent(int eventId) {
		return commentRepository.findByEventId(new Event(eventId));
	}

}
