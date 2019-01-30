package com.revature.krowdboot.utility;

import java.util.ArrayList;
import java.util.List;

import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.model.UserEvent;
import com.revature.krowdboot.model.UserEventId;
import com.revature.krowdboot.model.UserRole;

/*
 * @Author Moises Trevino
 */
public class MockUtility {

	public MockUtility() {
		super();
	}

	public Event getEvent() {

		return new Event(1, "Bonfire", "", "People standing by a fire", "2019-01-29T08:00", getAddress(), 21, 1,
				getEventCategory(), getUser());
	}

	public List<Event> getEventList() {

		List<Event> list = new ArrayList<>();

		List<Address> addressList = getAddressList();

		list.add(new Event(1, "Bonfire", "", "People standing by a fire", "2019-02-29T08:00", addressList.get(0), 21, 1,
				getEventCategory(), getUser()));
		list.add(new Event(2, "Fishing", "", "Let's go noodling", "2019-02-02T09:10", addressList.get(1), 22, 0,
				getEventCategory(), getUser()));
		list.add(new Event(3, "Concert", "", "Bad music, great vibes", "2019-03-13T12:09", addressList.get(2), 100, 1,
				getEventCategory(), getUser()));
		list.add(new Event(4, "Volunteer", "", "Help people out", "2019-02-11T08:11", addressList.get(3), 200, 0,
				getEventCategory(), getUser()));

		return list;

	}

	public User getUser() {
		User us = new User(1, "JohnDoe@Email.com", "John", "Doe", "JohnDoeUsername", "", 1, 0, getUserRole(2));
		return us;
	}

	public List<User> getUserList() {

		List<User> users = new ArrayList<User>();
		users.add(new User(1, "JohnDoe@Email.com", "John", "Doe", "JohnDoeUsername", "", 1, 0, getUserRole(2)));
		users.add(new User(2, "Arvester@Email.com", "Arvester", "Doe", "JohnDoeUsername", "", 12, 0, getUserRole(1)));
		users.add(new User(3, "Vegeta@Email.com", "Vegeta", "Doe", "VegetaUsername", "", 9001, 1, getUserRole(2)));
		users.add(new User(4, "Goku@Email.com", "Goku", "Doe", "VegetaUsername", "", 9002, 0, getUserRole(1)));
		return users;

	}

	public Comment getComment() {
		return new Comment(1, "This is a terrible event", 0, getUser(), getEvent());
	}

	public List<Comment> getCommentList() {

		List<Comment> comments = new ArrayList<Comment>();
		List<User> users = getUserList();
		List<Event> events = getEventList();

		comments.add(new Comment(1, "This is a terrible event", 0, users.get(0), events.get(1)));
		comments.add(new Comment(2, "This is a great event", 1, users.get(1), events.get(1)));
		comments.add(new Comment(3, "This is event was ok", 1, users.get(2), events.get(2)));
		comments.add(new Comment(4, "How is this an event?", 0, users.get(3), events.get(2)));

		return comments;

	}

	public Address getAddress() {
		return new Address(1, "1600 Pennsylvannia Avenue", "", "Washington D.C.", "Virginia", 12345);
	}

	public List<Address> getAddressList() {

		List<Address> list = new ArrayList<>();

		list.add(new Address(1, "First Address", "", "New York", "NY", 12345));
		list.add(new Address(2, "Second Address", "", "Tampa", "Florida", 22222));
		list.add(new Address(3, "Third Address", "", "Dallas", "Texas", 99999));
		list.add(new Address(4, "1600 Pennsylvannia Avenue", "", "Washington D.C.", "Virginia", 12345));

		return list;

	}

	public EventCategory getEventCategory() {
		return new EventCategory(1, "Outdoor");
	}

	public List<EventCategory> getEventCategoryList() {

		List<EventCategory> eventCategories = new ArrayList<EventCategory>();

		eventCategories.add(new EventCategory(0, "Outdoor"));
		eventCategories.add(new EventCategory(1, "Outdoor"));
		eventCategories.add(new EventCategory(2, "Music"));
		eventCategories.add(new EventCategory(3, "Volunteering"));

		return eventCategories;
	}

	public UserEvent getUserEvent() {
		return new UserEvent(getUser(), getEvent());
	}

	public List<UserEvent> getUserEventList() {

		List<UserEvent> userEvents = new ArrayList<UserEvent>();

		List<User> users = getUserList();
		List<Event> events = getEventList();
		List<UserEventId> userEventIds = getUserEventIdList();

		userEvents.add(new UserEvent(userEventIds.get(0), users.get(0), events.get(1), 1));
		userEvents.add(new UserEvent(userEventIds.get(1), users.get(1), events.get(1), 1));
		userEvents.add(new UserEvent(userEventIds.get(2), users.get(2), events.get(2), 1));
		userEvents.add(new UserEvent(userEventIds.get(3), users.get(3), events.get(2), 1));

		return userEvents;

	}

	public List<UserEventId> getUserEventIdList() {

		List<UserEventId> userEventIds = new ArrayList<UserEventId>();

		List<User> users = getUserList();
		List<Event> events = getEventList();

		userEventIds.add(new UserEventId(users.get(0).getId(), events.get(1).getId()));
		userEventIds.add(new UserEventId(users.get(1).getId(), events.get(1).getId()));
		userEventIds.add(new UserEventId(users.get(2).getId(), events.get(2).getId()));
		userEventIds.add(new UserEventId(users.get(3).getId(), events.get(2).getId()));

		return userEventIds;

	}

	public UserRole getUserRole(int role) {

		if (role == 1) {
			return new UserRole(1, "Admin");
		}
		return new UserRole(2, "User");

	}

}
