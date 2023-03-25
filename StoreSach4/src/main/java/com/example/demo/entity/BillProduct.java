//package com.example.demo.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Table(name = "bill_product")
//@Data
//
//public class BillProduct implements Serializable {
//
//	private static final long serialVersionID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	@Column(name = "unit_price")
//	private Long unitPrice;
//	
//	@Column(name = "quantity")
//	private Integer quantity;
//	
//	@ManyToOne
//	@JoinColumn(name = "product_id")
//	private Product product;
//	
//	@ManyToOne
//	@JoinColumn(name = "bill_id")
//	private Bill bill;
//	
//	public BillProduct() {
//		super();
//	}
//}
