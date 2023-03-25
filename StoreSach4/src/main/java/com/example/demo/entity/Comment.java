//package com.example.demo.entity;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import com.example.demo.entity2.User;
//
//import lombok.Data;
//
//@Entity
//@Table(name = "comment")
//@Data
//public class Comment implements Serializable{
//
//	private static final long serialVersionID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	@Column(name = "comment_date")
//	private Date commentDate;
//	
//	private String comment;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "product_id")
//	private Product product;
//}
