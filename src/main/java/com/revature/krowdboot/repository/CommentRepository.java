package com.revature.krowdboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;

/**
 * 
 * The repository interface that serves as the data access object for the
 * Comment class.
 * 
 * @author Unknown
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	public List<Comment> getCommentsByFlag(int flag);

	public List<Comment> findAll();

	public List<Comment> findByUserId(User user);

	public List<Comment> findByEventId(Event event);

}
