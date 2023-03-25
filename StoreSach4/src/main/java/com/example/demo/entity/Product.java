//package com.example.demo.entity;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Table(name = "product")
//@Data
//
//public class Product implements Serializable {
//	
//	private static final long serialVersionID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	private String name;
//	
//	private Long price;
//	
//	private String image;
//	
//	private String description;
//	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
//	private List<Review> review;
//	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
//	private List<Comment> comments;
//	
//	@ManyToOne
//	@JoinColumn(name = "category_id")
//	private Category category;
//	
//	@ManyToOne
//	@JoinColumn(name = "thuonghieu_id")
//	private ThuongHieu thuongHieu;
//	
//	@ManyToOne
//	@JoinColumn(name = "kichthuoc_id")
//	private KichThuoc kichThuoc;
//	
//	@ManyToOne
//	@JoinColumn(name = "gioitinh_id")
//	private GioiTinh gioiTinh;
//	
//	private Long soLuong;
//	 
//	public Product(int id) {
//		super();
//		this.id = id;
//	}
//	
//	public Product() {
//		super();
//	}
//}
