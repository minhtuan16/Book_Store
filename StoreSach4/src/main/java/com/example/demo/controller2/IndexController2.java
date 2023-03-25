package com.example.demo.controller2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity2.Product;
import com.example.demo.service2.ProductService2;

@Controller
public class IndexController2 {
	@Autowired
	private ProductService2 productService;
	
//	@GetMapping("/products") 
//	public String showIndex(Model model) {
//		model.addAttribute("products", productService.getAllProduct());
//		return "client/products";
//	} 
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView search(@RequestParam("value") String value) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/uiBook/fragments/searchFragment");
		List<Product> products = productService.searchProductByNameLike(value);
		mv.addObject("products", products);
		return mv;
	}
} 
 