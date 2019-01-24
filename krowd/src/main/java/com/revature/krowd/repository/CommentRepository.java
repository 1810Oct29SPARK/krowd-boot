package com.revature.krowd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowd.bean.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
