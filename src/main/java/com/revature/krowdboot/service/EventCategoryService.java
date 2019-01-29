package com.revature.krowdboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.repository.EventCategoryRepository;

/*
 * @Author Jonathan Snider & Stewart Gardner
*/

@Service
public class EventCategoryService {
	@Autowired
	private EventCategoryRepository ecr;
	
	
	public EventCategory getCategoryById(int id) {
		Optional<EventCategory> ec=ecr.findById(id);
		
		if (ec.isPresent()) {
			return ec.get();
		} else {
			return null;
		}
	}
	
	public List<EventCategory> getAllCategories(){
		List<EventCategory> ec=ecr.findAll();
		return ec;
	}
}
