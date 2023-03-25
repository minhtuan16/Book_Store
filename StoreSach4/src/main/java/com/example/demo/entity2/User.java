package com.example.demo.entity2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data

public class User  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name = "username", unique = true)
	private String username;
	
	private String password;
	
//	@ElementCollection(fetch = FetchType.EAGER)
//	@Column(name = "role")
//	@CollectionTable(name = "user_role",
//		joinColumns = @JoinColumn(name = "user_id"))
//	private List<String> roles;
	
	private String gender;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	private String address;
	
	private String phone;
	
	private int age;
	
	private String role;
	
	private String email;
	
	
	public User() {
		super();
	}
}
