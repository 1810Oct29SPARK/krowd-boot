package com.revature.krowdboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	public List<Comment> getCommentsByFlag(int flag);

}
