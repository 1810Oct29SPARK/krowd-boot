package com.revature.krowdboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.revature.krowdboot.model.Address;
import com.revature.krowdboot.model.Event;
import com.revature.krowdboot.model.EventCategory;
import com.revature.krowdboot.model.User;
import com.revature.krowdboot.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private EventCategoryService eventCategoryService;
	
	public List<Event> findallEvents(){
		List<Event> e= new ArrayList<>();
		e=eventRepository.findAll();
		return e;
	}
	
	public void addEvent(JSONObject json) {
		String name = (String) json.get("name");
		String picture = (String) json.get("picture");
		String description = (String) json.get("description");
		String date = (String) json.get("date");
		int score = Integer.parseInt((String) json.get("score"));
		int flag = Integer.parseInt((String) json.get("flag"));
		//the above are fine as is, the below need to call methods
		int userId = Integer.parseInt((String) json.get("userId"));
		User userObj = userService.getUserById(userId);
		//we need to call the get userById on the above
        int eventCategoryId = Integer.parseInt((String) json.get("categoryId"));
        EventCategory eventCategory = eventCategoryService.getCategoryById(eventCategoryId);
        //the above gets the Category
		String streetAddress = (String) json.get("streetAddress");
		String apartment = (String) json.get("apartment");
		String city = (String) json.get("city");
		String state = (String) json.get("state");
		int zipCode = Integer.parseInt((String) json.get("zipCode"));
		Address address = addressService.checkAddress(new Address(streetAddress,apartment,city,state,zipCode));
		Event e=new Event(name,picture,description,date,address,score,flag,eventCategory,userObj);
		eventRepository.save(e);
	}
	
	public void deleteEvent(Integer id) {
		Event e=eventRepository.getOne(id);
		eventRepository.delete(e);
	}
	
	public Event getEventById(Integer id) {
		Event e=eventRepository.getOne(id);
		return e;
	}
	
	public List<Event>getEventsByEventCategory(Integer id){
		List<Event> e=new ArrayList<>();
		eventRepository.getEventByCategoryId(id);
		return e;
	}
	
	public List<Event>getEventsByUser(Integer id){
		List<Event> e=new ArrayList<>();
		eventRepository.getEventByUserId(id);
		return e;
	}
}
	


