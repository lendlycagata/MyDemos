package com.careercitydashboard.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.careercitydashboard.Model.Users;

public interface UsersService {
	
	public List<Users> getAllUsers();
	public Users addUsers(Users users);
	public Users updateUsers(Users users);
	/*public Users updateUsers(Integer USER_ID);*/
	public Users getUsersById(Integer USER_ID);
	public Users saveUsers(Users users);

}
