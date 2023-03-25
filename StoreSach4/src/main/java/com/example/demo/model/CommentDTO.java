package com.example.demo.model;

import lombok.Data;

@Data

public class CommentDTO {

	private int id;
	
	private String commentDate;
	
	private String comment;
	
	private UserDTO userDTO;
	
	private ProductDTO productDTO;
}
