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

@Service
public class UserEventService {

	@Autowired
	private UserEventRepository userEventRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;

	public List<User> findAllUsersByEventId(Integer eventId) {
		List<User> users = new ArrayList<User>();
		List<UserEvent> userIds = userEventRepository.getUserIdByEventId(eventId);
		for (UserEvent ue : userIds) {
			User u = ue.getUser();
			users.add(u);
		}
		return users;
	}

	public List<Event> findAllEventsByUserId(Integer userId) {
		List<Event> events = new ArrayList<Event>();
		List<UserEvent> eventIds = userEventRepository.getEventIdByUserId(userId);

		for (UserEvent ue : eventIds) {
			Event e = ue.getEvent();
			events.add(e);
		}
		return events;
	}

	public void addUserEvent(Integer userId, Integer eventId) {
		User u = userService.getUserById(userId);
		Event e = eventService.getEventById(eventId);
		UserEventId ueId = new UserEventId(userId, eventId);
		UserEvent ue = new UserEvent(ueId, u, e, 0);
		userEventRepository.save(ue);
	}

	public Integer calculateEventScore(Integer eventId) {
		Integer Total = 0;
		List<UserEvent> userEvents = userEventRepository.getUserIdByEventId(eventId);
		for (UserEvent ue : userEvents) {
			Integer eventScore = ue.getRating();
			Total = Total + eventScore;
		}
		return Total;
	}

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

	public void updateUserEvent(JSONObject json) {
		int userId = Integer.parseInt((String) json.get("userId"));
		int eventId = Integer.parseInt((String) json.get("eventId"));
		int rating = Integer.parseInt((String) json.get("rating"));
		UserEvent ue = userEventRepository.findByUserIdLikeAndEventId(userId, eventId);
		ue.setRating(rating);
		userEventRepository.save(ue);
	}

}
