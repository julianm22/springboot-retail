package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logins")
public class Login {
	
	@Id
	@Column(name="username", length=30)
	private String username;
	@Column(name="password", length=30)
	private String password;
	@Column(name="type", length=30)
	private String type;
	
	public Login() {
	}

	public Login(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", type=" + type + "]";
	}

}
