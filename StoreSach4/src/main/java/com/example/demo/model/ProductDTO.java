package com.example.demo.model;

import lombok.Data;

@Data

public class ProductDTO {

	private int id;
	private String name;
	private Long price;
	private String image;
	private String description;
	private Long soLuong;
	
	private CategoryDTO category;
	
	private ThuongHieuDTO thuongHieuDTO;
	
	private KichThuocDTO kichThuocDTO;
	
	private GioiTinhDTO gioiTinhDTO;
	
}
