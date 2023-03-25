package com.example.demo.controller2;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity2.CartItem;
import com.example.demo.entity2.ShoppingCart;
import com.example.demo.entity2.User;
import com.example.demo.entity2.UserPrincipal;
import com.example.demo.repository2.CartItemRepository;
import com.example.demo.repository2.ShoppingCartRepository;
import com.example.demo.repository2.UserRepo;

@Controller

public class MemberController {
	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private UserRepo userRepo;

//	long ctId;
//	
//	@GetMapping(value = "member/bill")
//	public String shoppingCartDetail(HttpServletRequest request,
//			@RequestParam(name = "ctId", required = true) Long ctId,
//			@RequestParam(value = "keyword", required = false) Long keyword,
//			@RequestParam(value = "page", required = false) Integer page,
//			@RequestParam(name = "size", required = false) Integer size) {
//		
//		this.ctId = ctId;
//		keyword = ctId;
//		
//		if (size == null) {
//			size = 5;
//		}
//
//		if (page == null) {
//			page = 0;
//		}
//
//		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
//
////		if(keyword != null) {
//			List<CartItem> listCartItem = cartItemRepository.searchByShoppingCart(ctId);
//			
////			model.addAttribute("cartItems", pageCartItem.toList());
////			model.addAttribute("totalPage", pageCartItem.getTotalPages());
////		} else {
////			Page<CartItem> pageCartItem = cartItemRepository.findAll(pageable);
////
////			model.addAttribute("list", pageCartItem.toList());
////			model.addAttribute("totalPage", pageCartItem.getTotalPages());
////		}
//		
////		model.addAttribute("keyword", keyword == null ? "" : keyword);
////		model.addAttribute("ctId", ctId == null ? "" : ctId);
////		model.addAttribute("page", page);
////		model.addAttribute("size", size);
//			
//			request.setAttribute("listCartItem", listCartItem);
//			request.setAttribute("page", page);
//			request.setAttribute("keyword", keyword);
//		
//		return "member/bill";
//	}

	@GetMapping(value = "member/bills")
	public String shoppingCarts(Model model, 
//			@RequestParam(name = "username", required = false) String username,
			@RequestParam(value = "keyword", required = false) Long keyword,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {

//		this.ctId = ctId;
//		keyword = ctId;

		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println(principal.getId());
		keyword = principal.getId(); 
		
		if (size == null) {
			size = 5;
		}

		if (page == null) {
			page = 0;
		}

		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

		Page<ShoppingCart> pageShoppingCart = shoppingCartRepository.searchByUserId(keyword, pageable);
		model.addAttribute("bills", pageShoppingCart.toList());
		model.addAttribute("totalPage", pageShoppingCart.getTotalPages());

		model.addAttribute("keyword", keyword == null ? "" : keyword);
		model.addAttribute("page", page);
		model.addAttribute("size", size);

		return "member/bills";
	}
	
	// xoa item in list bill
//	@GetMapping(value = "/member/delete/bills")
//	public String deleteBillsProduct(@RequestParam(name = "billId") Long billId) {
//		shoppingCartRepository.deleteById(billId);
//		return "redirect:/member/bills";
//	}
}
