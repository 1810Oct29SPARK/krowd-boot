package com.revature.krowdboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowdboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
