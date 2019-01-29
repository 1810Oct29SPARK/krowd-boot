package com.revature.krowdboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.UserEvent;

/*
 * @Author Jonathan Snider & Stewart Gardner
*/

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Integer> {
	public List<UserEvent> getUserIdByEventId(int id);
	public List<UserEvent> getEventIdByUserId(int id);
<<<<<<< HEAD
	public UserEvent findByUserIdLikeAndEventId(int userId,int eventId);	
=======
	
	public UserEvent findByUserIdLikeAndEventId(int userId,int eventId);
>>>>>>> 5ce699ca055f52ed94acab6d7acb24dce6d2a4b1
}
