package com.stormy.actions.users;

public class LoginAction {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception{
		
		if(getUsername().equalsIgnoreCase("shridatt") && getPassword().equalsIgnoreCase("shri"))
			return "success";
		else 
			return "error";
	}
	
	
}
