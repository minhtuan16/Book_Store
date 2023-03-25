package com.example.demo.model;

import lombok.Data;

@Data
public class BookDTO {

	private int id;
	
	private String imageURL;
	
	private Long codeBook;
	
	private String nameBook;
	
	private String authorBook;
	
	private double priceBook;
	
	private String levelBook;
	
	private String schoolLevel;
	
	private String yearPublic;
	
	private int weightBook;
	
	private int numberPage;
	
	private String formBook;
	
	private String descriptionBook;
	
	private int quanityBook;
	
	private CategoryDTO categoryDTO;
	
	private KichThuocDTO kichThuocDTO;
	
	private NhaXuatBanDTO nxbDTO;
}
