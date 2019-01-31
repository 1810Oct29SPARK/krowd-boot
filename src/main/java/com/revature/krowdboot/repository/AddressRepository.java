package com.revature.krowdboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.Address;

/**
 * 
 * The repository interface that serves as the data access object for the
 * Address class.
 * 
 * @author Jonathan Snider & Stewart Gardner
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	public Address findAllByZipLikeAndStreetAddressLikeAndApartment(Integer zipcode, String streetAddress,
			String apartment);

}
