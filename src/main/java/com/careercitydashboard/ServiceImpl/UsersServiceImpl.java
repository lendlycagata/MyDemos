package com.careercitydashboard.ServiceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.careercitydashboard.Dao.UsersRepo;
import com.careercitydashboard.Model.Users;
import com.careercitydashboard.Service.UsersService;
import com.careercitydashboard.util.MyUserPrincipal;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<Users>) this.usersRepo.findAll();
	}

	@Override
	public Users addUsers(Users users) {
		// TODO Auto-generated method stub
		users.setPASSWORD(passwordEncoder.encode(users.getPASSWORD()));
		return this.usersRepo.save(users);
	}


	
	@Override
	public Users updateUsers(Users users) {
		// TODO Auto-generated method stub

		/*return this.usersRepo.findById(USER_ID).get();*/

		users.setPASSWORD(passwordEncoder.encode(users.getPASSWORD()));
		return this.usersRepo.save(users);

	}
	
	

	@Override
	public Users getUsersById(Integer USER_ID) {
		// TODO Auto-generated method stub
		return this.usersRepo.findById(USER_ID).get();
	}

	@Override
	public Users saveUsers(Users users) {
		// TODO Auto-generated method stub
		users.setPASSWORD(passwordEncoder.encode(users.getPASSWORD()));
		return this.usersRepo.save(users);
	}


		
	
}
