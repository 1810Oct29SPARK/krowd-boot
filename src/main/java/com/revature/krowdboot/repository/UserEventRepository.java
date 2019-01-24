package com.revature.krowdboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.UserEvent;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Integer> {

}
