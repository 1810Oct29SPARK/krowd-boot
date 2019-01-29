/*
 * AdminService highlights the methods that are associated with users whom are admins. The AdminService 
 * uses methods that are defined in the UserRepository, EventRepository, and CommentRepository. The 
 * methods include getting lists of flagged events and comments, deactivating users, updating users, 
 * and getting users by their account status.
 */

package com.revature.krowdboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.CommentRepository;
import com.revature.krowdboot.repository.EventRepository;
import com.revature.krowdboot.repository.UserRepository;

@Service
public class AdminService {
	
	private UserRepository userRepository;
	private EventRepository eventRepository;
	private CommentRepository commentRepository;
	
	/*
	 * Setter method for the EventRepository.
	 */
	@Autowired
	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	/*
	 * Setter method for the CommentRepository.
	 */
	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	/*
	 * Setter method for the UserRepository.
	 */
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	/*
	 * Method 
	 */
	public List<Comment> getFlaggedComments(int flag) {
		List<Comment> comments = commentRepository.getCommentsByFlag(flag);
		return comments;
	}
	
	public List<Event> getFlaggedEvents(int flag) {
		List<Event> events = eventRepository.getEventsByFlag(flag);
		return events;
	}
	
	public User deactivateUser(int id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			User user = u.get();
			user.setAccountStatus(1);
			user = userRepository.save(user);
			return user;	
		} else {
			return null;
		}
	}

}
