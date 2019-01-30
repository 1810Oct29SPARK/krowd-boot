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

	private EventCategoryRepository ecr;

	public EventCategoryRepository getEcr() {
		return ecr;
	}

	@Autowired
	public void setEcr(EventCategoryRepository ecr) {
		this.ecr = ecr;
	}

	public EventCategory getCategoryById(int id) {

		Optional<EventCategory> ec=ecr.findById(id);
		
		if (ec.isPresent()) {
			return ec.get();
		} else {
			return null;
		}

	}

	public List<EventCategory> getAllCategories() {
		List<EventCategory> ec = ecr.findAll();
		return ec;
	}

}
