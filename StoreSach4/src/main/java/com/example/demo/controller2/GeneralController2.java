package com.example.demo.controller2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity2.ShoppingCart;
import com.example.demo.entity2.WishList;
import com.example.demo.service2.ProductService2;
import com.example.demo.service2.ShoppingCartService2;
import com.example.demo.service2.WishListService2;

@ControllerAdvice
public class GeneralController2 {
	@Autowired
	private ShoppingCartService2 shoppingCartService;
	@Autowired
	private ProductService2 productService;
	@Autowired
	private WishListService2 wishlistService;
	 
	@ModelAttribute
	public void populateModel(Model model, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
	  String sessionTokenwishList = (String) request.getSession(true).getAttribute("sessiontTokenWishList");
		if(sessionToken == null) {
			model.addAttribute("shoppingCart", new ShoppingCart());
			
		}
		else {
			model.addAttribute("shoppingCart", shoppingCartService.getShoppingCartBySessionTokent(sessionToken));
			
		}
		
		if(sessionTokenwishList == null) {
			model.addAttribute("whishList", new WishList());
			
		}
		else {
			model.addAttribute("whishList", wishlistService.getWishListBySessionTokent(sessionTokenwishList));
		}
		model.addAttribute("categories",productService.getAllCategories());
		
		model.addAttribute("brands",productService.getAllBrands());
		model.addAttribute("featured",productService.getProductWithBigestDiscount());
	}
	

}
