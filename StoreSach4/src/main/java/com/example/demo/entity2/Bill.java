package com.example.demo.entity2;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bill")
@Data

public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "buy_date")
	private Date buyDate;
	
	@Column(name = "price_total")
	private Long priceTotal;

	@Column(name = "discount_percent")
	private Integer discountPercent;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User buyer;

	@Column(name = "status")
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
	private List<BillProduct> billProducts;
	 
	@Column(name = "pay")
	private String pay;
}
