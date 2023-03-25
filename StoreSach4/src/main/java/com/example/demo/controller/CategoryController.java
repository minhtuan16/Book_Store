//package com.example.demo.controller;
//
//import java.util.Arrays;
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
//import com.example.demo.entity.Category;
//import com.example.demo.model.CategoryDTO;
//import com.example.demo.repository.CategoryRepo;
//import com.example.demo.service.CategoryService;
//
////import java.util.Arrays;
////import java.util.List;
////
////import javax.validation.Valid;
////
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.data.domain.Page;
////import org.springframework.data.domain.PageRequest;
////import org.springframework.data.domain.Pageable;
////import org.springframework.data.domain.Sort;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.validation.BindingResult;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.ModelAttribute;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////
////import com.example.demo.entity.Category;
////import com.example.demo.repository.CategoryRepo;
////
////@Controller
////@RequestMapping("/admin/category")
////public class CategoryController {
////	private static Logger logger = LoggerFactory.getLogger(CategoryController.class);
////	
////	@Autowired
////	CategoryRepo categoryRepo;
////	
////
////	@GetMapping("/create")
////	public String create(Model model) {
////		List<Category> categories = categoryRepo.findAll();
////		model.addAttribute("categories", categories);
////		
////		model.addAttribute("cate", new Category());
////		return "admin/category/create";
////	}
////	
////	@PostMapping("/create")
////	public String create(@ModelAttribute("cate") @Valid Category category,
////			BindingResult bindingResult) {
////		
////		if(bindingResult.hasErrors()) {
////			return "admin/category/create";
////		}
////		categoryRepo.save(category);
////		
////		return "redirect:/admin/category/search";
////	}
////	
////	@GetMapping("/update")
////	public String update(@RequestParam("id") int id, Model model) {
////		List<Category> categories = categoryRepo.findAll();
////		model.addAttribute("categories", categories);
////		
////		Category category = categoryRepo.getById(id);
////		
////		model.addAttribute("cate", category);
////		return "admin/category/update";
////	}
////	
////	@PostMapping("/update")
////	public String update(@ModelAttribute Category cate) {
////		categoryRepo.save(cate);
////		
////		return "redirect:/admin/category/search";
////	}
////	
////	@GetMapping("/delete")
////	public String delete(@RequestParam("id") int id) {
////		categoryRepo.deleteById(id);
////		return "redirect:/admin/category/search";
////	}
////	
////	@GetMapping("/search")
////	public String search(Model model , 
////			@RequestParam(name = "id", required = false) Integer id ,
////			@RequestParam(name = "nameCategory", required = false) String nameCategory ,
////			@RequestParam(name = "page", required = false) Integer page ,
////			@RequestParam(name = "size", required = false) Integer size) {
////		
////		List<Category> categories = categoryRepo.findAll();
////		model.addAttribute("categories", categories);
////		
////		if(size == null) {
////			size = 15;
////		}
////		
////		if(page == null) {
////			page = 0;
////		}
////		
////		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
////		
////		if(nameCategory != null && !nameCategory.isEmpty()) {
////			Page<Category> pageCategory = categoryRepo.searchNameCate("%" + nameCategory + "%", pageable);
////			
////			model.addAttribute("list", pageCategory.toList());
////			model.addAttribute("totalPage", pageCategory.getTotalPages());
////		} else if(id != null) {
////			Category category = categoryRepo.findById(id).orElse(null);
////			if (category != null) {
////				model.addAttribute("list", Arrays.asList(category));
////			} else {
////				logger.info("id not found !");
////			}
////			model.addAttribute("totalPage", 0);
////		} else {
////			Page<Category> pageCategory = categoryRepo.findAll(pageable);
////			model.addAttribute("list", pageCategory.toList());
////			model.addAttribute("totalPage", pageCategory.getTotalPages());
////		}
////		
////		model.addAttribute("page", page);
////		model.addAttribute("size", size);
////		model.addAttribute("id", id == null ? "" : id);
////		model.addAttribute("nameCategory", nameCategory == null ? "" : nameCategory);
////		
////		return "admin/category/search";
////	}
////}
//
//@Controller
//public class CategoryController {
//	
//	@Autowired
//	private CategoryService categoryService;
//	
//	@Autowired
//	private CategoryRepo categoryRepo;
//	
//	@GetMapping(value = "/admin/category/create")
//	public String create() {
//		return "/admin/category/create";
//	}
//	
//	@PostMapping(value = "/admin/category/create")
//	public String create(@ModelAttribute CategoryDTO categoryDTO) {
//		categoryService.insert(categoryDTO);
//		return "redirect:/admin/category/search";
//	}
//	
//	@GetMapping(value = "/admin/category/update")
//	public String update(Model model, @RequestParam(value = "id") Integer id) {
//		CategoryDTO category = categoryService.get(id);
//		model.addAttribute("cate", category);
//		
//		return "/admin/category/update";
//	}
//	
//	@PostMapping(value = "/admin/category/update")
//	public String update(@ModelAttribute CategoryDTO categoryDTO) {
//		categoryService.update(categoryDTO);
//		return "redirect:/admin/category/search";
//	}
//	
//	@GetMapping(value = "/admin/category/delete")
//	public String delete(@RequestParam(value = "id") Integer id) {
//		categoryService.delete(id);
//		return "redirect:/admin/category/search";
//	}
//	
//	@GetMapping(value = "/admin/category/search")
//	public String searchCategory(HttpServletRequest request, 
////			@RequestParam(value = "id", required = false) Integer id,
//			@RequestParam(value = "keyword", required = false) String keyword,
//			@RequestParam(value = "page", required = false) Integer page) {
//		
//		page = page == null ? 1 : page;
//		keyword = keyword == null ? "" : keyword;
//		
////		
////		if(id != null) {
////			CategoryDTO category = categoryService.get(id);
////			if (category != null) {
////				request.setAttribute("list", Arrays.asList(category));
////			} 
////			request.setAttribute("page", 1);
////		}
//		
//		
//		
//		//mac dinh 10 ban ghi 1 trang
//		List<CategoryDTO> list = categoryService.search(keyword, 0, page*10);
//		request.setAttribute("list", list);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
////		request.setAttribute("id", id);
//		
//		return "/admin/category/search";
//	}
//}