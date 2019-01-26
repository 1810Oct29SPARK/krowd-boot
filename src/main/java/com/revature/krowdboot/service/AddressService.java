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
	
	public Address getAddressById(int id){
		Address a=addressRepository.getOne(id);
		return a;
	}
	
	public List<Address> getAllAddresses(){
		List<Address> a=addressRepository.findAll();
		return a;
	}
	
	public void addAddress(Address address) {
		addressRepository.save(address);
	}
	
	public Address checkAddress(Address address) {
		boolean inList = false;
		List<Address> a=addressRepository.findAll();
		for (Address addressInList : a) {
			if(a==addressInList) {
				inList = true;
				System.out.println("found with no id");
			}
		}
		if(!inList) {
			addressRepository.save(address);
		}
		
		return address;
		//how go we get the address with no id?
	}
}
