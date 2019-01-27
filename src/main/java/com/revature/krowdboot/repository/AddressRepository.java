package com.revature.krowdboot.repository;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.model.Event;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	public Address findAllByZipLikeAndStreetAddressLikeAndApartment(Integer zipcode, String streetAddress, String apartment);
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>  {
>>>>>>> 1526506574958ccf543bec45d3605bd069d9e5ea

}
