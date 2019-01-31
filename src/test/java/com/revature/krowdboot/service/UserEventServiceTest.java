
package com.revature.krowdboot.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.model.UserEvent;
import com.revature.krowdboot.repository.UserEventRepository;
import com.revature.krowdboot.utility.MockUtility;

public class UserEventServiceTest {

	MockUtility mock;

	@Mock
	UserEventRepository userEventRepositoryMock;

	@Mock
	UserService userServiceMock;

	@Mock
	EventService eventServiceMock;

	@InjectMocks
	UserEventService userEventService;

	@Test
	public void testFindAllUsersByEventId() {

		mock = new MockUtility();

		userEventRepositoryMock = mock(UserEventRepository.class);

		userEventService = new UserEventService();

		userEventService.setUserEventRepository(userEventRepositoryMock);

		List<UserEvent> userEvents = mock.getUserEventList();
		List<UserEvent> userEventsWithId = new ArrayList<UserEvent>();
		List<User> users = new ArrayList<User>();

		int eventId = 1;

		for (UserEvent userEvent : userEvents) {

			if (userEvent.getEvent().getId().equals(eventId)) {
				userEventsWithId.add(userEvent);
				users.add(userEvent.getUser());
			}
		}

		when(userEventRepositoryMock.getUserIdByEventId(eventId)).thenReturn(userEventsWithId);

		List<User> actual = userEventService.findAllUsersByEventId(eventId);

		assertEquals(users, actual);

	}

	@Test
	public void testFindAllEventsByUserId() {

		mock = new MockUtility();

		userEventRepositoryMock = mock(UserEventRepository.class);

		userEventService = new UserEventService();

		userEventService.setUserEventRepository(userEventRepositoryMock);

		List<UserEvent> userEvents = mock.getUserEventList();
		List<UserEvent> userEventsWithId = new ArrayList<UserEvent>();
		List<Event> events = new ArrayList<Event>();

		int userId = 1;

		for (UserEvent userEvent : userEvents) {

			if (userEvent.getUser().getId() == userId) {
				userEventsWithId.add(userEvent);
				events.add(userEvent.getEvent());
			}
		}

		when(userEventRepositoryMock.getEventIdByUserId(userId)).thenReturn(userEventsWithId);

		List<Event> actual = userEventService.findAllEventsByUserId(userId);

		assertEquals(events, actual);
	}

	@Test
	public void testCalculateEventScore() {

		mock = new MockUtility();

		userEventRepositoryMock = mock(UserEventRepository.class);

		userEventService = new UserEventService();

		userEventService.setUserEventRepository(userEventRepositoryMock);

		List<UserEvent> userEvents = mock.getUserEventList();
		List<UserEvent> userEventsWithId = new ArrayList<UserEvent>();

		int eventId = 1;
		int Total = 0;

		for (UserEvent userEvent : userEvents) {

			if (userEvent.getEvent().getId().equals(eventId)) {
				userEventsWithId.add(userEvent);
				Total += userEvent.getRating();
			}
		}

		when(userEventRepositoryMock.getUserIdByEventId(eventId)).thenReturn(userEventsWithId);

		int actual = userEventService.calculateEventScore(eventId);

		assertEquals(Total, actual);
	}

}
