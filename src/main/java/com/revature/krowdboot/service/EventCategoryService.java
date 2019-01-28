package com.revature.krowdboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.repository.EventCategoryRepository;

@Service
public class EventCategoryService {

	private EventCategoryRepository ecr;

	public EventCategoryRepository getEcr() {
		return ecr;
	}

	@Autowired
	public void setEcr(EventCategoryRepository ecr) {
		this.ecr = ecr;
	}

	public EventCategory getCategoryById(int id) {
		EventCategory ec = ecr.getOne(id);
		return ec;
	}

	public List<EventCategory> getAllCategories() {
		List<EventCategory> ec = ecr.findAll();
		return ec;
	}

}
