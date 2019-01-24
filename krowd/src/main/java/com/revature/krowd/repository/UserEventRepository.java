package com.revature.krowd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowd.bean.UserEvent;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Integer>{

}
