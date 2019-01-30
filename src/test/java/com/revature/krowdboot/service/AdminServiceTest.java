package com.revature.krowdboot.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.krowdboot.model.Comment;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.CommentRepository;
import com.revature.krowdboot.repository.EventRepository;
import com.revature.krowdboot.repository.UserRepository;
import com.revature.krowdboot.utility.MockUtility;

/*
 * @Author Moises Trevino
 */

public class AdminServiceTest {

	MockUtility mock;

	@Mock
	UserRepository userRepositoryMock;

	@Mock
	EventRepository eventRepositoryMock;

	@Mock
	CommentRepository commentRepositoryMock;

	@InjectMocks
	private AdminService adminService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetFlaggedComments() {

		mock = new MockUtility();

		commentRepositoryMock = mock(CommentRepository.class);

		adminService = new AdminService();

		adminService.setCommentRepository(commentRepositoryMock);

		List<Comment> comments = mock.getCommentList();

		List<Comment> flagged = new ArrayList<>();

		for (Comment comment : comments) {
			if (comment.getFlag() == 1) {
				flagged.add(comment);
			}
		}

		when(commentRepositoryMock.getCommentsByFlag(1)).thenReturn(flagged);

		List<Comment> actual = adminService.getFlaggedComments(1);

		assertEquals(flagged, actual);

	}

	@Test
	public void testGetFlaggedEvents() {

		mock = new MockUtility();

		eventRepositoryMock = mock(EventRepository.class);

		adminService = new AdminService();

		adminService.setEventRepository(eventRepositoryMock);

		List<Event> events = mock.getEventList();

		List<Event> flagged = new ArrayList<>();

		for (Event event : events) {
			if (event.getFlag() == 1) {
				flagged.add(event);
			}
		}

		when(eventRepositoryMock.getEventsByFlag(1)).thenReturn(flagged);

		List<Event> actual = adminService.getFlaggedEvents(1);

		assertEquals(flagged, actual);

	}

	
	@Test
	public void testDeactivateUser() {

		mock = new MockUtility();

		userRepositoryMock = mock(UserRepository.class);

		adminService = new AdminService();

		adminService.setUserRepository(userRepositoryMock);

		User user = mock.getUser();
		User flaggedUser = user;
		flaggedUser.setAccountStatus(1);

		int id = 1;

		when(userRepositoryMock.getById(id)).thenReturn(user);

		when(userRepositoryMock.save(flaggedUser)).thenReturn(flaggedUser);

		User actual = adminService.deactivateUser(id);

		assertEquals(flaggedUser, actual);

	}

}
