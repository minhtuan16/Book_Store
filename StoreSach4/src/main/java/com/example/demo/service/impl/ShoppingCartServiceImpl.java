//package com.example.demo.service.impl;
//
//import java.util.Date;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.CartItem;
//import com.example.demo.entity.Product;
//import com.example.demo.entity.ShoppingCart;
//import com.example.demo.repository.CartItemRepo;
//import com.example.demo.repository.ShoppingCartRepo;
//import com.example.demo.service.Product_Service_2;
//import com.example.demo.service.ShoppingCartService;
//
//@Service
//public class ShoppingCartServiceImpl implements ShoppingCartService {
//
//
//	@Autowired
//	private ShoppingCartRepo shoppingCartRepo;
//	
//	@Autowired
//	private CartItemRepo cartItemRepo;
//	
//	@Autowired
//	private Product_Service_2 productService_2;
//
//	@Override
//	public ShoppingCart addShoppingCartFirstTime(int id, String sessionToken, int quantity) {
//		ShoppingCart shoppingCart = new ShoppingCart();
//		
//		CartItem cartItem = new CartItem();
//		cartItem.setQuantity(quantity);
//		cartItem.setDate(new Date());
//		cartItem.setProduct(productService_2.getProductById(id));
//		
//		shoppingCart.getItems().add(cartItem);
//		shoppingCart.setSessionToken(sessionToken);
//		shoppingCart.setDate(new Date());
//		
//		return shoppingCartRepo.save(shoppingCart);
//	} 
//	
//	@Override
//	public ShoppingCart addToExistingShoppingCart(int id, String sessionToken, int quantity) {
//		ShoppingCart shoppingCart = shoppingCartRepo.findBySessionToken(sessionToken);
//		
//		Product product = productService_2.getProductById(id);
//		Boolean productDoesExistInTheCart = false;
//		
//		if(shoppingCart != null) {
//			Set<CartItem> items = shoppingCart.getItems();
//			for(CartItem item : items) {
//				if(item.getProduct().equals(product)) {
//					productDoesExistInTheCart = true;
//					item.setQuantity(item.getQuantity() + quantity);
//					shoppingCart.setItems(items);
//					
//					return shoppingCartRepo.saveAndFlush(shoppingCart);
//				}
//			}
//		}
//		
//		if(!productDoesExistInTheCart && (shoppingCart != null)) {
//			CartItem cartItem = new CartItem();
//			cartItem.setDate(new Date());
//			cartItem.setQuantity(quantity);
//			cartItem.setProduct(product);
//			shoppingCart.getItems().add(cartItem);
//			return shoppingCartRepo.saveAndFlush(shoppingCart);
//		}
//		return this.addShoppingCartFirstTime(id, sessionToken, quantity);
//	}
//
//	@Override
//	public ShoppingCart getShoppingCartBySessionTokent(String sessionToken) {
//		return shoppingCartRepo.findBySessionToken(sessionToken);
//	}
//
//	@Override
//	public CartItem updateShoppingCartItem(int id, int quantity) {
//		CartItem cartItem = cartItemRepo.findById(id).get();
//		cartItem.setQuantity(quantity);
//		return cartItemRepo.saveAndFlush(cartItem);
//	}
//
//	@Override
//	public ShoppingCart removeCartIemFromShoppingCart(int id, String sessionToken) {
//		ShoppingCart shoppingCart = shoppingCartRepo.findBySessionToken(sessionToken);
//		Set<CartItem> items = shoppingCart.getItems();
//		CartItem cartItem = null;
//		for (CartItem item : items) {
//			if(item.getId() == id) {
//				cartItem = item;
//			}
//		}
//		items.remove(cartItem);
//		cartItemRepo.delete(cartItem);
//		shoppingCart.setItems(items);
//		return shoppingCartRepo.save(shoppingCart);
//	}
//
//	@Override
//	public void clearShoppingCart(String sessionToken) {
//		ShoppingCart sh = shoppingCartRepo.findBySessionToken(sessionToken);
//		
//		shoppingCartRepo.delete(sh);
//	}
//	
//	
//}
