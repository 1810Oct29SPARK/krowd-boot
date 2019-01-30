package com.revature.krowdboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.repository.EventCategoryRepository;

/**
 * 
 * The service class that manages the communication between the DAO layer and
 * the controller layer for the EventCategory class.
 * 
 * @author Jonathan Snider & Stewart Gardner
 *
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

	/**
	 * 
	 * The method that gets an event category by its ID.
	 * 
	 * @param id
	 * @return the event category
	 */
	public EventCategory getCategoryById(int id) {

		Optional<EventCategory> ec = ecr.findById(id);

		if (ec.isPresent()) {
			return ec.get();
		} else {
			return null;
		}

	}

	/**
	 * 
	 * The method that retrieves and returns a list of all event categories.
	 * 
	 * @return the event category list
	 */
	public List<EventCategory> getAllCategories() {
		List<EventCategory> ec = ecr.findAll();
		return ec;
	}

}
