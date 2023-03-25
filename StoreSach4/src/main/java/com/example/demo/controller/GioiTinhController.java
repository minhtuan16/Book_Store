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
//import com.example.demo.model.GioiTinhDTO;
//import com.example.demo.service.GioiTinhService;
//
//@Controller
//
//public class GioiTinhController {
//
//	@Autowired
//	private GioiTinhService gioiTinhService;
//
//	@GetMapping(value = "/admin/gioi-tinh/search")
//	public String search(HttpServletRequest request, @RequestParam(name = "keyword", required = false) String keyword,
//			@RequestParam(name = "page", required = false) Integer page) {
//
//		page = page == null ? 1 : page;
//		keyword = keyword == null ? "" : keyword; 
//
//		List<GioiTinhDTO> gioiTinhDTOs = gioiTinhService.search(keyword, 0, page * 10);
//		request.setAttribute("list", gioiTinhDTOs); 
//		request.setAttribute("keyword", keyword);
//		request.setAttribute("page", page);
//
//		return "/admin/gioi-tinh/search";
//	}
//
//	@GetMapping(value = "/admin/gioi-tinh/create")
//	public String create() {
//		return "/admin/gioi-tinh/create";
//	}
//
//	@PostMapping(value = "/admin/gioi-tinh/create")
//	public String create(@ModelAttribute GioiTinhDTO gioiTinhDTO) {
//		gioiTinhService.insert(gioiTinhDTO);
//
//		return "redirect:/admin/gioi-tinh/search";
//	}
//
//	@GetMapping(value = "/admin/gioi-tinh/update")
//	public String update(Model model, @RequestParam(name = "id") int id) {
//		GioiTinhDTO gioiTinhDTO = gioiTinhService.getById(id);
//
//		model.addAttribute("gioiTinh", gioiTinhDTO);
//		return "/admin/gioi-tinh/update";
//	}
//
//	@PostMapping(value = "/admin/gioi-tinh/update")
//	public String update(@ModelAttribute GioiTinhDTO gioiTinhDTO) {
//		gioiTinhService.update(gioiTinhDTO);
//
//		return "redirect:/admin/gioi-tinh/search";
//	}
//
//	@GetMapping(value = "/admin/gioi-tinh/delete")
//	public String delete(@RequestParam(name = "id") int id) {
//		gioiTinhService.delete(id);
//
//		return "redirect:/admin/gioi-tinh/search";
//	}
//}
