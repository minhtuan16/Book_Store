package com.example.demo.model;

import lombok.Data;

@Data

public class ReviewDTO {

	private int id;
	
	private int starNumber;
	
	private String reviewDate;
	
	private UserDTO userDTO;
	
	private ProductDTO productDTO;
	
	public ReviewDTO() {
		super();
	}
}
