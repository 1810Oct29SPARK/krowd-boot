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

/**
 * 
 * AdminService highlights the methods that are associated with users whom are
 * admins. The AdminService uses methods that are defined in the UserRepository,
 * EventRepository, and CommentRepository. The methods include getting lists of
 * flagged events and comments, deactivating users, updating users, and getting
 * users by their account status.
 * 
 * @author Unknown
 *
 */
@Service
public class AdminService {

	private UserRepository userRepository;
	private EventRepository eventRepository;
	private CommentRepository commentRepository;

	/**
	 * 
	 * The setter method for the EventRepository.
	 * 
	 * @param eventRepository
	 */
	@Autowired
	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	/**
	 * 
	 * The setter method for the CommentRepository.
	 * 
	 * @param commentRepository
	 */
	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	/**
	 * 
	 * The setter method for the userRepository.
	 * 
	 * @param userRepository
	 */
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * 
	 * The method that returns all flagged comments.
	 * 
	 * @param flag
	 * @return the comment list
	 */
	public List<Comment> getFlaggedComments(int flag) {
		List<Comment> comments = commentRepository.getCommentsByFlag(flag);
		return comments;
	}

	/**
	 * 
	 * The method that returns all flagged events.
	 * 
	 * @param flag
	 * @return the event list
	 */
	public List<Event> getFlaggedEvents(int flag) {
		List<Event> events = eventRepository.getEventsByFlag(flag);
		return events;
	}

	/**
	 * 
	 * The methods that deactivates a user.
	 * 
	 * @param id
	 * @return the deactivated user
	 */
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
