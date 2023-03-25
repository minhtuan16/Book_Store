package com.example.demo.model;

import lombok.Data;

@Data
public class BillDTO {

	private int id;

	private String buyDate;

	private Long priceTotal;
	
	private Integer discountPercent;
	
	private String status;
	
	private String pay;
	
	private UserDTO userDTO;
}
