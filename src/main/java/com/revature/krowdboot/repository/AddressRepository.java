package com.revature.krowdboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.Address;

/*
 * @Author Jonathan Snider & Stewart Gardner
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	public Address findAllByZipLikeAndStreetAddressLikeAndApartment(Integer zipcode, String streetAddress,
			String apartment);

}
