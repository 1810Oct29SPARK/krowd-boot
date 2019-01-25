package com.revature.krowdboot.service;



import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.repository.EventCategoryRepository;

public class EventCategoryService {
	private EventCategoryRepository ecr;
	
	
	public EventCategory getCategoryById(int id) {
		EventCategory ec=ecr.getOne(id);
		return ec;
	}
}
