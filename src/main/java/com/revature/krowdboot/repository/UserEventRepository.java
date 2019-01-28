package com.revature.krowdboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.UserEvent;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Integer> {

	public List<UserEvent> getUserIdByEventId(int id);

	public List<UserEvent> getEventIdByUserId(int id);

	public UserEvent findByUserIdLikeAndEventId(int userId, int eventId);

	// public UserEvent findAllByZipLikeAndStreetAddressLikeAndApartment(int
	// userId,int eventId);

}
