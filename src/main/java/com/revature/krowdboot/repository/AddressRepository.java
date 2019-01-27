package com.revature.krowdboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.model.Event;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	public Address findAllByZipLikeAndStreetAddressLikeAndApartment(Integer zipcode, String streetAddress, String apartment);

}
