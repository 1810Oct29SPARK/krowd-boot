package com.revature.krowd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.krowd.bean.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
