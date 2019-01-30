package com.revature.krowdboot.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.UserRepository;
import com.revature.krowdboot.utility.MockUtility;

public class UserServiceTest {
	
	MockUtility mock;

	@Mock
	UserRepository userRepositoryMock;

	@InjectMocks
	private UserService userService;


	@Test
	public void testFindAllUsers() {
		
		mock = new MockUtility();

		userRepositoryMock = mock(UserRepository.class);

		userService = new UserService();

		userService.setUserRepository(userRepositoryMock);

		List<User> users = mock.getUserList(); 

		when(userRepositoryMock.findAll()).thenReturn(users);

		List<User> actual = userService.findAllUsers(); 

		assertEquals(users, actual);

	}

	@Ignore
	@Test
	public void testDeleteUserById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserById() {
		
		mock = new MockUtility();

		userRepositoryMock = mock(UserRepository.class);

		userService = new UserService();

		userService.setUserRepository(userRepositoryMock);

		User user = mock.getUser();
		
		int id = user.getId(); 

		when(userRepositoryMock.getById(id)).thenReturn(user);

		User actual = userService.getUserById(id); 

		assertEquals(user, actual);
	}

	@Test
	public void testFindUserByUsername() {
		
		mock = new MockUtility();

		userRepositoryMock = mock(UserRepository.class);

		userService = new UserService();

		userService.setUserRepository(userRepositoryMock);

		User user = mock.getUser();
		
		String username = user.getUsername(); 

		when(userRepositoryMock.findByUsername(username)).thenReturn(user);

		User actual = userService.findUserByUsername(username); 

		assertEquals(user, actual);
	}

	@Ignore
	@Test
	public void testCreateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		
		mock = new MockUtility();

		userRepositoryMock = mock(UserRepository.class);

		userService = new UserService();

		userService.setUserRepository(userRepositoryMock);

		User user = mock.getUser();
		
		int id = user.getId(); 

		when(userRepositoryMock.save(user)).thenReturn(user);

		int actual = userService.updateUser(user); 

		assertEquals(id, actual);
	}

}
