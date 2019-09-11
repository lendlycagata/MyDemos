package com.careercitydashboard.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careercitydashboard.Model.Users;

@Repository
public interface UsersRepo  extends JpaRepository<Users, Integer>{
	
	
	

}
