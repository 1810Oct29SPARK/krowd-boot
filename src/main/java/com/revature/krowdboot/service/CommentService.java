package com.revature.krowdboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.CommentRepository;

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

	public void deleteCommentById(int id) {
		commentRepository.deleteById(id);
	}

	public Comment createAComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public Comment updateComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public List<Comment> getByUser(int userId) {
		return commentRepository.findByUserId(new User(userId));
	}

	public List<Comment> getByEvent(int eventId) {
		return commentRepository.findByEventId(new Event(eventId));
	}

}
