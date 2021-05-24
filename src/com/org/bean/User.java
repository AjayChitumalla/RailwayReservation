package com.org.bean;

import java.util.Date;

public class User {
	private String username;
	private String email;
	private Date dob;
	private String gender;
	private String address;
	private String password;
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", dob=" + dob + ", gender=" + gender + ", address="
				+ address + ", password=" + password + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
