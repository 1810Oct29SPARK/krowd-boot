package com.revature.krowdboot.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.model.UserEvent;
import com.revature.krowdboot.model.UserEventId;
import com.revature.krowdboot.repository.UserEventRepository;

/**
 * 
 * The service class that manages the communication between the DAO layer and
 * the controller layer for the UserEvent class.
 * 
 * @author Jonathan Snider & Stewart Gardner
 *
 */
@Service
public class UserEventService {

	@Autowired
	private UserEventRepository userEventRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;
	
	public UserEventRepository getUserEventRepository() {
		return userEventRepository;
	}

	public void setUserEventRepository(UserEventRepository userEventRepository) {
		this.userEventRepository = userEventRepository;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	/**
	 * 
	 * The method that retrieves and returns all users that are attending a specific
	 * event.
	 * 
	 * @param eventId
	 * @return the user list
	 */
	public List<User> findAllUsersByEventId(Integer eventId) {
		List<User> users = new ArrayList<User>();
		List<UserEvent> userIds = userEventRepository.getUserIdByEventId(eventId);
		for (UserEvent ue : userIds) {
			User u = ue.getUser();
			users.add(u);
		}
		return users;
	}

	/**
	 * 
	 * The methods that retrieves and returns all events that a user has RSVPed for.
	 * 
	 * @param userId
	 * @return the event list
	 */
	public List<Event> findAllEventsByUserId(Integer userId) {
		List<Event> events = new ArrayList<Event>();
		List<UserEvent> eventIds = userEventRepository.getEventIdByUserId(userId);

		for (UserEvent ue : eventIds) {
			Event e = ue.getEvent();
			events.add(e);
		}
		return events;
	}

	/**
	 * 
	 * The method that allows a user to RSVP for an event.
	 * 
	 * @param userId
	 * @param eventId
	 */
	public void addUserEvent(Integer userId, Integer eventId) {
		User u = userService.getUserById(userId);
		Event e = eventService.getEventById(eventId);
		UserEventId ueId = new UserEventId(userId, eventId);
		UserEvent ue = new UserEvent(ueId, u, e, 0);
		userEventRepository.save(ue);
	}

	/**
	 * 
	 * The method that calculates and returns the cumulative score of an event based
	 * on user reviews.
	 * 
	 * @param eventId
	 * @return the score
	 */
	public Integer calculateEventScore(Integer eventId) {
		Integer Total = 0;
		List<UserEvent> userEvents = userEventRepository.getUserIdByEventId(eventId);
		for (UserEvent ue : userEvents) {
			Integer eventScore = ue.getRating();
			Total = Total + eventScore;
		}
		return Total;
		
	}

	/**
	 * 
	 * The method that calculates and returns the reputation of a user.
	 * 
	 * @param userId
	 * @return the reputation score
	 */
	public Integer calculateReputation(Integer userId) {
		Integer Total = 0;
		List<Event> eventsByUser = eventService.getEventsByUser(userId);
		List<Integer> eventIdList = new ArrayList<>();
		for (Event e : eventsByUser) {
			eventIdList.add(e.getId());
		}
		for (Integer eventId : eventIdList) {
			Total = Total + calculateEventScore(eventId);
		}
		return Total;
	}

	/**
	 * 
	 * The method that allows a user to rate an event he attended.
	 * 
	 * @param json
	 */
	public void updateUserEvent(JSONObject json) {
		int userId = json.getInt("userId");
		int eventId = json.getInt("eventId");
		int rating = json.getInt("rating");
		UserEvent ue = userEventRepository.findByUserIdLikeAndEventId(userId, eventId);
		ue.setRating(rating);
		userEventRepository.save(ue);
	}

}
