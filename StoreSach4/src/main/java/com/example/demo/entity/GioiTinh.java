//package com.example.demo.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Table(name = "gioi_tinh")
//@Data
//public class GioiTinh implements Serializable {
//
//	private static final long serialVersionID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	private String name;
//
//	public GioiTinh(int id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
//	
//	public GioiTinh() {
//		super();
//	}
//}