package com.revature.krowdboot.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;

import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.repository.AddressRepository;

public class AddressServiceTest {
	
	@Mock
	AddressRepository addressRepositoryMock;
	
	@InjectMocks
	private AddressService addressService; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetAddressById() {
		
		addressRepositoryMock = mock(AddressRepository.class);
		
		addressService = new AddressService(addressRepositoryMock);
		
		int id = 1; 
		
		Address address = new Address(id, "Street Address", "", "City", "State", 12345);
		
		when(addressRepositoryMock.getOne(id)).thenReturn(address); 
		
		Address actual = addressService.getAddressById(id); 
		
		assertEquals(address, actual); 
	}

	@Test
	public void testGetAllAddresses() {
		
		addressRepositoryMock = mock(AddressRepository.class);
		
		addressService = new AddressService(addressRepositoryMock);
		
		List <Address> list = new ArrayList<>();
		
		list.add(new Address(1, "First Address", "", "New York", "NY", 12345)); 
		list.add(new Address(2, "Second Address", "", "Tampa", "Florida", 22222));
		list.add(new Address(3, "Third Address", "", "Dallas", "Texas", 99999));
	
		when(addressRepositoryMock.findAll()).thenReturn(list); 

		List <Address> actual = addressService.getAllAddresses(); 
		
		assertEquals(list, actual); 
	}

	@Ignore
	@Test
	public void testAddAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckAddress() {
		
		addressRepositoryMock = mock(AddressRepository.class);
		
		addressService = new AddressService(addressRepositoryMock);
		
		int id = 1; 
		
		Address address = new Address(id, "Street Address", "", "City", "State", 12345);
		
		when(addressRepositoryMock.findAllByZipLikeAndStreetAddressLikeAndApartment(address.getZip(),
				address.getStreetAddress(), address.getApartment())).thenReturn(address);
		
		Address actual = addressService.checkAddress(address); 
		
		assertEquals(address, actual); 
	}

}
