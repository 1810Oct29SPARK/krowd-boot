package com.revature.krowdboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public Address getAddressById(int id) {
		Address a = addressRepository.getOne(id);
		return a;
	}

	public List<Address> getAllAddresses() {
		List<Address> a = addressRepository.findAll();
		return a;
	}

	public void addAddress(Address address) {
		addressRepository.save(address);
	}

	public Address checkAddress(Address address) {
<<<<<<< HEAD
		boolean inList = false;
		List<Address> a=addressRepository.findAll();
		for (Address addressInList : a) {
			if(address==addressInList) {
				inList = true;
				System.out.println("found with no id");
			}
		}
		if(!inList) {
=======

		Integer zip = address.getZip();
		String streetAddress = address.getStreetAddress();
		String apartment = address.getApartment();
		Address checkedAddress = addressRepository.findAllByZipLikeAndStreetAddressLikeAndApartment(zip, streetAddress, apartment);
		if (checkedAddress == null) {
>>>>>>> bbfc3c062869328e14acf52c0427482d2f641bd6
			addressRepository.save(address);
			return address;
		}
		return checkedAddress;
	}
}
