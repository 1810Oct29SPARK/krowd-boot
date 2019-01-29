package com.revature.krowdboot.service;

import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.*;

import com.revature.krowdboot.repository.EventRepository;

public class EventServiceTest {
	
	@Mock
	EventRepository eventRepositoryMock;
	
	@InjectMocks
	private EventService eventService;
	
	@BeforeClass
	public static void SetupBeforeClass() throws Exception {}
	
	@AfterClass
	public static void TearDownAfterClass() throws Exception {}

	@Test
	public void testGetEventById() {
		eventRepositoryMock = mock(EventRepository.class);
		eventService = new EventService(eventRepositoryMock);
		
	}
	
	
}
