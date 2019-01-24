package com.revature.krowd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowd.bean.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
