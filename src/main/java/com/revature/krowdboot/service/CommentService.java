package com.revature.krowdboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Comment;
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
		return commentRepository.getCommentById(id);
	}

	public void deleteCommentById(int id) {
		commentRepository.deleteById(id);
	}

	public Comment createAComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public void updateComment(Comment comment) {
		commentRepository.save(comment);
	}

}
