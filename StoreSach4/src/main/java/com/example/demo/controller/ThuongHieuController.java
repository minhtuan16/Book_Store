//package com.example.demo.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.model.ThuongHieuDTO;
//import com.example.demo.service.ThuongHieuService;
//
//@Controller
//
//public class ThuongHieuController {
//
//	@Autowired
//	private ThuongHieuService thuongHieuService;
//	
//	@GetMapping(value = "/admin/thuong-hieu/search")
//	public String search(HttpServletRequest request,
//			@RequestParam(name = "keyword", required = false) String keyword,
//			@RequestParam(name = "page", required = false) Integer page) {
//		
//		page = page == null ? 1: page;
//		keyword = keyword == null ? "" : keyword;
//		
//		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.search(keyword, 0, page * 10);
//		request.setAttribute("thuongHieuList", thuongHieuDTOs);
//		request.setAttribute("keyword", keyword);
//		request.setAttribute("page", page);
//		
//		return "/admin/thuong-hieu/search";
//	}
//	
//	@GetMapping(value = "/admin/thuong-hieu/create")
//	public String create() {
//		return "/admin/thuong-hieu/create";
//	}
//	
//	@PostMapping(value = "/admin/thuong-hieu/create")
//	public String create(@ModelAttribute ThuongHieuDTO thuongHieuDTO) {
//		thuongHieuService.insert(thuongHieuDTO);
//		
//		return "redirect:/admin/thuong-hieu/search";
//	}
//	
//	@GetMapping(value = "/admin/thuong-hieu/update")
//	public String update(Model model, @RequestParam(name = "id") int id) {
//		ThuongHieuDTO thuongHieuDTO = thuongHieuService.get(id);
//		
//		model.addAttribute("thuonghieu", thuongHieuDTO);
//		return "/admin/thuong-hieu/update";
//	}
//	
//	@PostMapping(value = "/admin/thuong-hieu/update")
//	public String update(@ModelAttribute ThuongHieuDTO thuongHieuDTO) {
//		thuongHieuService.update(thuongHieuDTO);
//		
//		return "redirect:/admin/thuong-hieu/search";
//	}
//	
//	@GetMapping(value = "/admin/thuong-hieu/delete")
//	public String delete(@RequestParam(name = "id") int id) {
//		thuongHieuService.delete(id);
//		
//		return "redirect:/admin/thuong-hieu/search";
//	}
//}
