package com.revature.krowdboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

		String name =json.getString("name");
		String picture =json.getString("picture");
		String description =json.getString("description");
		String date = json.getString("date");
		int score =json.getInt("score");
		int flag =json.getInt("flag");
		//the above are fine as is, the below need to call methods
		int userId =json.getInt("userId");
		User userObj = userService.getUserById(userId);
		//we need to call the get userById on the above
        int eventCategoryId =json.getInt("categoryId");
        EventCategory eventCategory = eventCategoryService.getCategoryById(eventCategoryId);
        //the above gets the Category
		String streetAddress =json.getString("streetAddress");
		String apartment =json.getString("apartment");
		String city =json.getString("city");
		String state =json.getString("state");
		int zipCode =json.getInt("zipCode");
		Address address = addressService.checkAddress(new Address(streetAddress,apartment,city,state,zipCode));
		Event e=new Event(name,picture,description,date,address,score,flag,eventCategory,userObj);
		eventRepository.save(e);
	}
	
	public void updateEvent(JSONObject json) {
		Integer id = json.getInt("id");
		String name = json.getString("name");
		String picture = json.getString("picture");
		String description = json.getString("description");
		String date = json.getString("date");
		int score = json.getInt("score");
		int flag = json.getInt("flag");
		//the above are fine as is, the below need to call methods
		int userId = json.getInt("userId");
		User userObj = userService.getUserById(userId);
		//we need to call the get userById on the above
        int eventCategoryId = json.getInt("categoryId");
        EventCategory eventCategory = eventCategoryService.getCategoryById(eventCategoryId);
        //the above gets the Category
		String streetAddress = json.getString("streetAddress");
		String apartment = json.getString("apartment");
		String city = json.getString("city");
		String state = json.getString("state");
		int zipCode = json.getInt("zipCode");
		Address address = addressService.checkAddress(new Address(streetAddress,apartment,city,state,zipCode));
		Event e=new Event(id,name,picture,description,date,address,score,flag,eventCategory,userObj);
		eventRepository.save(e);
	}
	
	public void deleteEvent(Integer id) {
		eventRepository.deleteById(id);
	}
	
	public Event getEventById(Integer id) {
		Optional<Event> e=eventRepository.findById(id);
		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}
	
	public List<Event>getEventsByEventCategory(Integer id){
		List<Event> e=new ArrayList<>();
		EventCategory eventCategory = eventCategoryService.getCategoryById(id);
		e=eventRepository.getEventsByCategoryId(eventCategory);
		return e;
	}
	
	public List<Event>getEventsByUser(Integer id){
		List<Event> e=new ArrayList<>();
		User user = userService.getUserById(id);
		e=eventRepository.getEventsByUserId(user);
		return e;
	}
	
	public List<Event>getEventsByFlag(){
		List<Event> e= new ArrayList<>();
		e=eventRepository.getEventsByFlag(1);
		return e;
	}
}
	


