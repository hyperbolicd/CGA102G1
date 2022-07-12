package com.websocketchat.model;

import java.util.Set;

//POJO

public class State {
	private String type; //type = 大吳老師0201版的 action
	// the user changing the state ， 跟資料庫沒有關聯
	
	private String user; //誰上線了
	// total users
	
	private Set<String> users; //目前線上的使用者

	public State(String type, String user, Set<String> users) {
		super();
		this.type = type;
		this.user = user;
		this.users = users;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Set<String> getUsers() {
		return users;
	}

	public void setUsers(Set<String> users) {
		this.users = users;
	}

}
