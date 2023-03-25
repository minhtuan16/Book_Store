package com.example.demo.controller2;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity2.Product;
import com.example.demo.entity2.ShoppingCart;
import com.example.demo.entity2.UserPrincipal;
import com.example.demo.repository2.ShoppingCartRepository;
import com.example.demo.service2.Cate_TH_KT_GT_Coupon_Service;
import com.example.demo.service2.ProductService2;

@Controller

public class ClientController {

	@Autowired
	private ProductService2 productService;

	@Autowired
	private Cate_TH_KT_GT_Coupon_Service service;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	// @RequestMapping(value = "/")
//	private String index(HttpServletRequest request) {
//		return "redirect:/products";
//	}

	@RequestMapping(value = "/member/home")
	private String home(HttpServletRequest request) {
//			return "redirect:/admin/user/search";

		if (request.isUserInRole("ROLE_ADMIN"))
			return "redirect:/admin/user/search";
		return "redirect:/products";
	}

	@GetMapping("/products")
	public String showIndex(Model model, HttpServletRequest request) {

		Integer page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
		request.setAttribute("page", page);

		model.addAttribute("products", productService.getAllProduct());
		model.addAttribute("thuongHieus", service.getAllThuongHieu());
		return "client/products";
	}

	@GetMapping("/detail/{id}")
	public String showIndex(@PathVariable("id") Long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "/client/product";
	}

	@GetMapping(value = "/bills")
	public String shoppingCarts(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam(name = "keyword", required = false) Long keyword,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		
//		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("sessiontToken");
//	    if (shoppingCart != null) {
//	        // Xóa các item trong giỏ hàng cũ
//	        shoppingCart.clearItems();
//	    } else {
//	        // Tạo mới giỏ hàng
//	        shoppingCart = new ShoppingCart();
//	        // Tạo sessionToken mới cho giỏ hàng
//	        String sessionToken = UUID.randomUUID().toString();
//	        shoppingCart.setSessionToken(sessionToken);
//	        // Lưu giỏ hàng vào session
//	        session.setAttribute("shoppingCart", shoppingCart);
//	    }

//		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
//
//		session.removeAttribute(sessionToken);
//		sessionToken = UUID.randomUUID().toString();
//		request.getSession().setAttribute("sessiontToken", sessionToken);

//		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
//		// TODO: Thực hiện các thao tác để tạo đơn hàng
//		session.clearItems();
//		session.setAttribute("sessiontToken", sessiontToken);

		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
	@GetMapping(value = "/delete/bills")
	public String deleteBillsProduct(@RequestParam(name = "billId") Long billId) {
		shoppingCartRepository.deleteById(billId);
		return "redirect:/bills";
	}
}
