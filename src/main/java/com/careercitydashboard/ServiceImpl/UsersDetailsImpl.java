package com.careercitydashboard.ServiceImpl;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;



import com.careercitydashboard.Model.Users;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UsersDetailsImpl implements UserDetails {
	
	
	
	private static final long serialVersionUID = 1256711395932122675L;
	private Users users;
	
	public UsersDetailsImpl (Users users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return users.getRoles().stream().map(role ->new SimpleGrantedAuthority("USER_ROLE_" + role)).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return users.getPASSWORD();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
