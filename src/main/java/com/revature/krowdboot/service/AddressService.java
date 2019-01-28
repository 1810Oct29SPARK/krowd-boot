package com.revature.krowdboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.repository.AddressRepository;

@Service
public class AddressService {

	private AddressRepository addressRepository;

	public AddressRepository getAddressRepository() {
		return addressRepository;
	}

	@Autowired
	public void setAddressRepository(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

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

		Integer zip = address.getZip();
		String streetAddress = address.getStreetAddress();
		String apartment = address.getApartment();
		Address checkedAddress = addressRepository.findAllByZipLikeAndStreetAddressLikeAndApartment(zip, streetAddress,
				apartment);
		if (checkedAddress == null) {
			addressRepository.save(address);
			return address;
		}
		return checkedAddress;
	}

}
