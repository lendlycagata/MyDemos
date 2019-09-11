package com.careercitydashboard.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer USER_ID;
	
	private String USER_FNAME;
	private String USER_LNAME;
	
	@Column(name="USER_EMPID")
	private String username;
	
	private String PASSWORD;
	private String USER_GROUP;
	
	
	private Boolean USER_STATUS;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles;

	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_FNAME() {
		return USER_FNAME;
	}

	public void setUSER_FNAME(String uSER_FNAME) {
		USER_FNAME = uSER_FNAME;
	}

	public String getUSER_LNAME() {
		return USER_LNAME;
	}

	public void setUSER_LNAME(String uSER_LNAME) {
		USER_LNAME = uSER_LNAME;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getUSER_GROUP() {
		return USER_GROUP;
	}

	public void setUSER_GROUP(String uSER_GROUP) {
		USER_GROUP = uSER_GROUP;
	}

	public Boolean getUSER_STATUS() {
		return USER_STATUS;
	}

	public void setUSER_STATUS(Boolean uSER_STATUS) {
		USER_STATUS = uSER_STATUS;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Users [USER_ID=" + USER_ID + ", USER_FNAME=" + USER_FNAME + ", USER_LNAME=" + USER_LNAME + ", username="
				+ username + ", PASSWORD=" + PASSWORD + ", USER_GROUP=" + USER_GROUP + ", USER_STATUS=" + USER_STATUS
				+ ", roles=" + roles + "]";
	}

	
	
	
	
}
