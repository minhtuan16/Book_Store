package com.example.demo.model;

import lombok.Data;

@Data

public class BillProductDTO {

	private int id;
	
	private Long unitPrice;
	
	private int quantity;
	
	private ProductDTO productDTO;
	
	private BillDTO billDTO;
}
