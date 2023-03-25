package com.example.demo.controller2;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service2.ShoppingCartService2;

@Controller
public class CartController2 {
 
	@Autowired
	private ShoppingCartService2 shoppingCartService;

	@PostMapping("/addToCart2")
	public String addToCart(HttpServletRequest request, Model model, @RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {

		// sessiontToken
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if (sessionToken == null) {

			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessiontToken", sessionToken);
			shoppingCartService.addShoppingCartFirstTime(id, sessionToken, quantity);
			
		} else {
			shoppingCartService.addToExistingShoppingCart(id, sessionToken, quantity);

		}
		
		
		return "redirect:/products";
	}
	
	@GetMapping("/shoppingCart2")
	public String showShoopingCartView() {
		
		return "/client/shoppingCart";
	}

	@PostMapping("/updateShoppingCart2")
	public String updateCartItem(@RequestParam("item_id") Long id,
			@RequestParam("quantity") int quantity) {
		
		shoppingCartService.updateShoppingCartItem(id,quantity);
		return "redirect:/shoppingCart2";
	}
	@GetMapping("/removeCartItem2/{id}")
	public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		System.out.println("got here ");
		shoppingCartService.removeCartIemFromShoppingCart(id,sessionToken);
		return "redirect:/shoppingCart2";
	}
	
	@GetMapping("/clearShoppingCart2")
	public String clearShoopiString(HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		request.getSession(false).removeAttribute("sessiontToken");
		shoppingCartService.clearShoppingCart(sessionToken);
		return "redirect:/shoppingCart2";
	}
}
