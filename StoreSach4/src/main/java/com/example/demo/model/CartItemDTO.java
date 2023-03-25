package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data

public class CartItemDTO {

	private int id;
	private String name;
	private int quantity;
	private Date date;
	private ProductDTO productDTO;
}
