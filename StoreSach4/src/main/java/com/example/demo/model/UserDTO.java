package com.example.demo.model;

import lombok.Data;

@Data
public class UserDTO {

	private int id;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String gender;
	
	private Boolean enabled;
	
	private String address;
	
	private String phone;
	
	private int age;
	
	private String role;
	
	private String email;
	
	public UserDTO() {
		super();
	}

	public UserDTO(int id, String name, String username, String password, String gender, Boolean enabled, String address,
			String phone, int age, String role, String email) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.enabled = enabled;
		this.address = address;
		this.phone = phone;
		this.age = age;
		this.role = role;
		this.email = email;
	}
	
	
}
