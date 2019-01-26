package com.revature.krowdboot.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.repository.EventCategoryRepository;

@Service
public class EventCategoryService {
	@Autowired
	private EventCategoryRepository ecr;
	
	
	public EventCategory getCategoryById(int id) {
		EventCategory ec=ecr.getOne(id);
		return ec;
	}
	
	public List<EventCategory> getAllCategories(){
		List<EventCategory> ec=ecr.findAll();
		return ec;
	}
}
