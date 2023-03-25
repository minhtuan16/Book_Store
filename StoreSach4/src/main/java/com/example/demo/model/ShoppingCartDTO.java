package com.example.demo.model;

import java.util.Date;
import java.util.Set;

public class ShoppingCartDTO {

	private int id;
	private Date date;
	private Double totalPrice;
	private int itemsNumber;
	private String sessionToken;
	
	private Set<CartItemDTO> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalPrice() {
		Double sum = 0.0;
		for (CartItemDTO item : items) {
			sum = sum + item.getProductDTO().getPrice() * item.getQuantity();
		}
		return sum;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getItemsNumber() {
		return itemsNumber;
	}

	public void setItemsNumber(int itemsNumber) {
		this.itemsNumber = itemsNumber;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public Set<CartItemDTO> getItems() {
		return items;
	}

	public void setItems(Set<CartItemDTO> items) {
		this.items = items;
	}
	
	
}
