package com.revature.krowdboot.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.*;
import org.mockito.*;

import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.model.UserRole;
import com.revature.krowdboot.repository.EventCategoryRepository;
import com.revature.krowdboot.repository.EventRepository;
import com.revature.krowdboot.utility.DateUtility;


public class EventServiceTest {

	@Mock
	EventRepository eventRepositoryMock;

	@Mock
	EventCategoryRepository eventCategoryRepositoryMock;

	@InjectMocks
	private EventService eventService;

	@BeforeClass
	public static void SetupBeforeClass() throws Exception {
	}

	@AfterClass
	public static void TearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetEventById() {

		eventRepositoryMock = mock(EventRepository.class);
		eventService = new EventService(eventRepositoryMock);
		int id = 1;

		Event event = new Event(id, "First Meet Up!",
				"https://images.unsplash.com/photo-1517457373958-b7bdd4587205?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=600&q=60",
				"Krowd Tampa has it''s first meeting today! I''d love to see you there.", "2019-01-27T12:00",
				new Address(1, "123 Boogie Woogie Ave", null, "St. Petersburg", "FL", 33705), 0, 0,
				new EventCategory(7, "Other"),
				new User(1, "Grandma@art.com", "Grandmother", "Moses", "ArtForAll",
						"https://mholloway63.files.wordpress.com/2013/12/grandma-moses-9416251-1-402.jpg?w=560", 1234,
						1, new UserRole(2, "Admin")));
		Optional<Event> opEvent = Optional.of(event);

		when(eventRepositoryMock.findById(id)).thenReturn(opEvent);
		Event actual = eventService.getEventById(id);
		assertEquals(opEvent.get(), actual);

	}

}
