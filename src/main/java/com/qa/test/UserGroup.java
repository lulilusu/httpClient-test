package com.qa.test;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
	
	private String username;
	private List<User> users = new ArrayList<User>();
	public UserGroup(String username, List<User> users) {
		this.username = username;
		this.users = users;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "UserGroup [username=" + username + ", users=" + users + "]";
	}

}
