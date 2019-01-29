package com.revature.krowdboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	public AddressService() {
	}
	
	public AddressService(AddressRepository addressRepositoryMock) {
		this.addressRepository = addressRepositoryMock;
	}

	public Address getAddressById(int id) {
		Optional<Address> a = addressRepository.findById(id);
		if (a.isPresent()) {
			return a.get();
		} else {
			return null;
		}
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
		Address checkedAddress = addressRepository.findAllByZipLikeAndStreetAddressLikeAndApartment(zip, streetAddress, apartment);
		if (checkedAddress == null) {
			addressRepository.save(address);
			return address;
		}
		return checkedAddress;
	}
}
