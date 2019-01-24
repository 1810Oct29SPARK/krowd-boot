package com.revature.krowdboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
