package com.example.demo.model;

import lombok.Data;

@Data
public class ThuongHieuDTO {

	private int id;
	
	private String name;
	
	public ThuongHieuDTO() {
		super();
	}
	
	public ThuongHieuDTO( String name) {
		super();
		this.name = name;
	}

	public ThuongHieuDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
