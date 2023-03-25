package com.example.demo.controller2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity2.Product;
import com.example.demo.service2.ProductService2;

@Controller
public class DetailsController2 {
	@Autowired   
	private ProductService2 productService;

//	@GetMapping("/detail/{id}")
//	public String showIndex(@PathVariable("id") Long id, Model model) {
//		Product produt = productService.getProductById(id);
//		model.addAttribute("product", produt);
//		return "/uiBook/details";
//	}
}
 