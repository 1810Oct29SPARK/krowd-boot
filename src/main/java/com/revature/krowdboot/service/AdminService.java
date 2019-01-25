package com.revature.krowdboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.CommentRepository;
import com.revature.krowdboot.repository.EventRepository;
import com.revature.krowdboot.repository.UserRepository;

public class AdminService {
	
	private UserRepository userRepository;
	private EventRepository eventRepository;
	private CommentRepository commentRepository;
	
	@Autowired
	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getUserByAccountStatus(int status) {
		User user = userRepository.getUserByAccountStatus(status);
		return user;
	}
	
	public List<Comment> getFlaggedComments(int flag) {
		List<Comment> comments = commentRepository.getCommentsByFlag(flag);
		return comments;
	}
	
	public List<Event> getFlaggedEvents(int flag) {
		List<Event> events = eventRepository.getEventsByFlag(flag);
		return events;
	}
	
	public User updateUser(User user) {
		
		User u = userRepository.save(user);
		return u;
		
	}
	
	public User deactivateUser(int id) {
		User u = userRepository.getOne(id);
		u.setAccountStatus(1);
		u = userRepository.save(u);
		return u;
	}

}
