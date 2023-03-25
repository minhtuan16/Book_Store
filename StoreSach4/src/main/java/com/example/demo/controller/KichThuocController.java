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
//import com.example.demo.model.KichThuocDTO;
//import com.example.demo.model.ThuongHieuDTO;
//import com.example.demo.service.KichThuocService;
//
//@Controller
//
//public class KichThuocController {
//
//	@Autowired
//	private KichThuocService kichThuocService;
//	
//	@GetMapping(value = "/admin/kich-thuoc/search")
//	public String search(HttpServletRequest request,
//			@RequestParam(name = "keyword", required = false) String keyword,
//			@RequestParam(name = "page", required = false) Integer page) {
//		
//		page = page == null ? 1: page;
//		keyword = keyword == null ? "" : keyword;
//		
//		List<KichThuocDTO> kichThuocDTOs = kichThuocService.search(keyword, 0, page * 10);
//		request.setAttribute("kichThuocList", kichThuocDTOs);
//		request.setAttribute("keyword", keyword);
//		request.setAttribute("page", page);
//		
//		return "/admin/kich-thuoc/search";
//	}
//	
//	@GetMapping(value = "/admin/kich-thuoc/create")
//	public String create() {
//		return "/admin/kich-thuoc/create";
//	}
//	
//	@PostMapping(value = "/admin/kich-thuoc/create")
//	public String create(@ModelAttribute KichThuocDTO kichThuocDTO) {
//		kichThuocService.insert(kichThuocDTO);
//		
//		return "redirect:/admin/kich-thuoc/search";
//	}
//	
//	@GetMapping(value = "/admin/kich-thuoc/update")
//	public String update(Model model, @RequestParam(name = "id") int id) {
//		KichThuocDTO kichThuocDTO = kichThuocService.get(id);
//		
//		model.addAttribute("kichThuoc", kichThuocDTO);
//		return "/admin/kich-thuoc/update";
//	}
//	
//	@PostMapping(value = "/admin/kich-thuoc/update")
//	public String update(@ModelAttribute KichThuocDTO kichThuocDTO) {
//		kichThuocService.update(kichThuocDTO);
//		
//		return "redirect:/admin/kich-thuoc/search";
//	}
//	
//	@GetMapping(value = "/admin/kich-thuoc/delete")
//	public String delete(@RequestParam(name = "id") int id) {
//		kichThuocService.delete(id);
//		
//		return "redirect:/admin/kich-thuoc/search";
//	}
//}
//
