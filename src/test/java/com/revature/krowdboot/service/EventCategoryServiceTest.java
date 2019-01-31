package com.revature.krowdboot.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.repository.EventCategoryRepository;
import com.revature.krowdboot.utility.MockUtility;

public class EventCategoryServiceTest {
	
	MockUtility mock; 
	
	@Mock 
	EventCategoryRepository eventCategoryRepositoryMock; 
	
	@InjectMocks
	private EventCategoryService eventCategoryService;

	@Test
	public void testGetCategoryById() {
		
		mock = new MockUtility();

		eventCategoryRepositoryMock = mock(EventCategoryRepository.class);

		eventCategoryService = new EventCategoryService();

		eventCategoryService.setEcr(eventCategoryRepositoryMock);

		EventCategory eventCategory = mock.getEventCategory(); 
		
		int id = eventCategory.getId(); 
		
		Optional<EventCategory> optionalEventCategory = Optional.of(eventCategory); 
		
		when(eventCategoryRepositoryMock.findById(id)).thenReturn(optionalEventCategory);

		EventCategory actual = eventCategoryService.getCategoryById(id); 

		assertEquals(eventCategory, actual);
		
	}

	@Test
	public void testGetAllCategories() {
		
		mock = new MockUtility();

		eventCategoryRepositoryMock = mock(EventCategoryRepository.class);

		eventCategoryService = new EventCategoryService();

		eventCategoryService.setEcr(eventCategoryRepositoryMock);

		List<EventCategory> eventCategories = mock.getEventCategoryList(); 
		
		when(eventCategoryRepositoryMock.findAll()).thenReturn(eventCategories);

		List<EventCategory> actual = eventCategoryService.getAllCategories(); 

		assertEquals(eventCategories, actual);
	}

}
