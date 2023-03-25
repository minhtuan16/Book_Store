package com.example.demo.model;

import lombok.Data;

@Data

public class GioiTinhDTO {

	private int id;
	
	private String name;
	
	public GioiTinhDTO() {
		super();
	}
	
	public GioiTinhDTO(String name) {
		super();
		this.name = name;
	}

	public GioiTinhDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
