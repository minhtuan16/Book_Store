////package com.example.demo.controller;
////
////import java.io.File;
////import java.io.IOException;
////import java.nio.file.Files;
////import java.util.Arrays;
////import java.util.List;
////
////import javax.servlet.http.HttpServletResponse;
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
////import org.springframework.web.multipart.MultipartFile;
////
////import com.example.demo.entity.Category;
////import com.example.demo.entity.Product;
////import com.example.demo.entity.Size;
////import com.example.demo.repository.CategoryRepo;
////import com.example.demo.repository.ProductRepo;
////import com.example.demo.repository.SizeRepo;
////
////@Controller
////@RequestMapping("/admin/product")
////public class ProductController {
////	
////	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
////
////	@Autowired
////	ProductRepo productRepo;
////	
////	@Autowired
////	CategoryRepo categoryRepo;
////	
////	@Autowired
////	SizeRepo sizeRepo;
////	
////	
//////	@GetMapping("/products-details")
//////	@RolesAllowed(value = { "ROLE_Member" })
//////	public String productsDetails(HttpServletRequest request) {
//////		//check xem user da co tai khoan member chua
//////		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//////		System.err.println(currentUser.getUsername());
//////		
//////		if(request.isUserInRole("Member")) {
//////			System.out.println("Member");
//////		}
//////		return "shopStore/products-details";
//////	}
////	
////	@GetMapping("/create")
////	public String create(Model model) {
////		List<Category> categories = categoryRepo.findAll();
////		model.addAttribute("categories", categories);
////		
////		List<Size> sizes = sizeRepo.findAll();
////		model.addAttribute("sizes", sizes);
////		
////		model.addAttribute("pro", new Product());
////		return "/admin/product/create";
////	}
////	
////	@PostMapping("/create")
////	public String create(@ModelAttribute("pro") @Valid Product product,
////			@RequestParam(name = "file", required = false) MultipartFile file,
////			BindingResult bindingResult) {
////		
////		if(bindingResult.hasErrors()) {
////			return "/admin/product/create";
////		}
////		
////		// luu lai file vao 1 folder, sau do lay url save to db
////		if(file != null && file.getSize() > 0) {
////			try {
////				final String folder = "D:/JavaCore/ShopShoes/picture/upload";
////				String originFilename = file.getOriginalFilename();
////			
////				File newFile = new File(folder + "/" +originFilename);
////			
////				// copy noi dung file upload vao file new
////				file.transferTo(newFile);
////				
////				//luu lai vao db
////				product.setImageURL(originFilename);
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
////		productRepo.save(product);
////		
////		return "redirect:/admin/product/search";
////	}
////	
////	@GetMapping("/update")
////	public String update(@RequestParam("id") int id, Model model) throws  IOException {
////		
////		Product product = productRepo.getById(id);
////		
////		List<Category> categories = categoryRepo.findAll();
////		model.addAttribute("categories", categories);
////		
////		List<Size> sizes = sizeRepo.findAll();
////		model.addAttribute("sizes", sizes);
////		
////		model.addAttribute("product", product);
////		return "/admin/product/update";
////	}
////	
////	@PostMapping("/update")
////	public String update(@ModelAttribute Product product) {
////		
////		
////		productRepo.save(product);
////		
////		return "redirect:/admin/product/search";
////	}
////	
////	@GetMapping("/delete")
////	public String delete(@RequestParam("id") int id) {
////		productRepo.deleteById(id);
////		
////		return "redirect:/admin/product/search";
////	}
////	
////	@GetMapping("/search")
////	public String search(Model model ,
////			@RequestParam(name = "id", required = false) Integer id ,
////			@RequestParam(name = "name", required = false) String name ,
////			@RequestParam(name = "categoryID", required = false) Integer categoryID ,
////			@RequestParam(name = "page", required = false) Integer page ,
////			@RequestParam(name = "size", required = false) Integer size ) {
////		
////		List<Category> categories = categoryRepo.findAll();
////		model.addAttribute("categories", categories);
////		
////		List<Size> sizes = sizeRepo.findAll();
////		model.addAttribute("sizes", sizes);
////		
////		if(size == null) {
////			size = 10;
////		}
////		
////		if(page == null) {
////			page = 0;
////		}
////		
////		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
////		
////		if(categoryID != null && name != null && !name.isEmpty()) {
////			Page<Product> pageProduct = productRepo.searchCategoryIdAndNameP(categoryID, "%" + name + "%", pageable);
////			model.addAttribute("list", pageProduct.toList());
////			model.addAttribute("totalPage", pageProduct.getTotalPages());
////		} else if (categoryID != null) {
////			Page<Product> pageProduct = productRepo.searchCategoryId(categoryID, pageable);
////			model.addAttribute("list", pageProduct.toList());
////			model.addAttribute("totalPage", pageProduct.getTotalPages());
////		} else if (categoryID == null && name != null && !name.isEmpty()) {
////			Page<Product> pageProduct = productRepo.searchNameP("%" + name + "%", pageable);
////			model.addAttribute("list", pageProduct.toList());
////			model.addAttribute("totalPage", pageProduct.getTotalPages());
////		} else if (id != null) {
////			Product product = productRepo.findById(id).orElse(null);
////			if(product != null) {
////				model.addAttribute("list", Arrays.asList(product));
////			} else {
////				logger.info("id not found");
////			}
////			model.addAttribute("totalPage", 0);
////		} else {
////			Page<Product> pageProduct = productRepo.findAll(pageable);
////			model.addAttribute("list", pageProduct.toList());
////			model.addAttribute("totalPage", pageProduct.getTotalPages());
////		}
////		 
////		model.addAttribute("page", page);
////		model.addAttribute("size", size);
////		model.addAttribute("categoryID", categoryID == null ? "" : categoryID);
////		model.addAttribute("name", name == null ? "" : name);
////		model.addAttribute("id", id == null ? "" : id);
////		
////		return "/admin/product/search";
////	} 
////	
////	
////	@GetMapping("/download")
////	public void download(@RequestParam("imageURL") String imageURL
////			, HttpServletResponse response) {
////		final String folder = "D:/JavaCore/ShopStore/picture/upload";
////		
////		File file = new File(folder + "/" + imageURL);
////		if(file.exists()) {
////			try {
////				Files.copy(file.toPath(), response.getOutputStream());
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
////		}
////	}
////}
//
////package com.example.demo.controller;
////
////import java.io.File;
////import java.io.FileNotFoundException;
////import java.io.FileOutputStream;
////import java.io.IOException;
////import java.nio.file.Files;
////import java.util.List;
////
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.ModelAttribute;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.multipart.MultipartFile;
////
////import com.example.demo.model.CategoryDTO;
////import com.example.demo.model.GioiTinhDTO;
////import com.example.demo.model.KichThuocDTO;
////import com.example.demo.model.ProductDTO;
////import com.example.demo.model.ThuongHieuDTO;
////import com.example.demo.service.CategoryService;
////import com.example.demo.service.GioiTinhService;
////import com.example.demo.service.KichThuocService;
////import com.example.demo.service.ProductService;
////import com.example.demo.service.ThuongHieuService;
////
////@Controller
////
////public class ProductController {
////
////	@Autowired
////	private ProductService productService;
////
////	@Autowired
////	private CategoryService categoryService;
////
////	@Autowired
////	private ThuongHieuService thuongHieuService;
////
////	@Autowired
////	private KichThuocService kichThuocService;
////
////	@Autowired
////	private GioiTinhService gioiTinhService;
////
////	@GetMapping(value = "/admin/product/create")
////	public String create(HttpServletRequest request, Model model) {
////
////		model.addAttribute("product", new ProductDTO());
////
////		List<CategoryDTO> listCate = categoryService.search("", 0, 10);
////		request.setAttribute("listCate", listCate);
////
////		List<ThuongHieuDTO> listTH = thuongHieuService.search("", 0, 10);
////		request.setAttribute("listTH", listTH);
////
////		List<KichThuocDTO> listKT = kichThuocService.search("", 0, 10);
////		request.setAttribute("listKT", listKT);
////
////		List<GioiTinhDTO> listGT = gioiTinhService.search("", 0, 10);
////		request.setAttribute("listGT", listGT);
////
////		return "/admin/product/create";
////	}
////
////	@PostMapping(value = "/admin/product/create")
////	public String create(@ModelAttribute(name = "product") ProductDTO product,
////			@RequestParam(name = "imagefile") MultipartFile imagefile) {
////
//////		String originalFileName = imagefile.getOriginalFilename();
//////		int lastIndex = originalFileName.lastIndexOf(".");
//////		String ext = originalFileName.substring(lastIndex);
//////
//////		String avatarFileName = System.currentTimeMillis() + ext;
//////		File newFile = new File("D:/JavaCore/BookStore/picture/upload" + avatarFileName);
//////		FileOutputStream fileOutputStream;
//////		try {
//////			fileOutputStream = new FileOutputStream(newFile);
//////			fileOutputStream.write(imagefile.getBytes());
//////			fileOutputStream.close();
//////		} catch (FileNotFoundException e) {
//////			e.printStackTrace();
//////		} catch (Exception e) {
//////			e.printStackTrace();
//////		}
//////
//////		product.setImage(avatarFileName);
////		
////		if(imagefile != null && imagefile.getSize() > 0) {
////			try {
////				final String folder = "D:/JavaCore/BookStore/picture/upload";
////				String originFilename = imagefile.getOriginalFilename();
////			
////				File newFile = new File(folder + "/" +originFilename);
////			
////				// copy noi dung file upload vao file new
////				imagefile.transferTo(newFile);
////				
////				//luu lai vao db
////				product.setImage(originFilename);
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
////		productService.insert(product);
////
////		return "redirect:/admin/product/search";
////	}
////
////	@GetMapping(value = "/admin/product/update")
////	public String update(HttpServletRequest request, Model model, int id) {
////		ProductDTO product = productService.get(id);
////
////		List<CategoryDTO> listCate = categoryService.search("", 0, 10);
////		request.setAttribute("listCate", listCate);
////
////		List<ThuongHieuDTO> listTH = thuongHieuService.search("", 0, 10);
////		request.setAttribute("listTH", listTH);
////
////		List<KichThuocDTO> listKT = kichThuocService.search("", 0, 10);
////		request.setAttribute("listKT", listKT);
////
////		List<GioiTinhDTO> listGT = gioiTinhService.search("", 0, 10);
////		request.setAttribute("listGT", listGT);
////
////		model.addAttribute("product", product);
////		return "/admin/product/update";
////	}
////
////	@PostMapping(value = "/admin/product/update")
////	public String update(@ModelAttribute ProductDTO product,
////			@RequestParam(name = "imagefile", required = false) MultipartFile imagefile) {
//////		String originalFilename = imagefile.getOriginalFilename();
//////		int lastIndex = originalFilename.lastIndexOf(".");
//////		String ext = originalFilename.substring(lastIndex);
//////
//////		String avatarFileName = System.currentTimeMillis() + ext;
//////		File newFile = new File("D:/JavaCore/BookStore/picture/upload" + avatarFileName);
//////		FileOutputStream fileOutputStream;
//////		try {
//////			fileOutputStream = new FileOutputStream(newFile);
//////			fileOutputStream.write(imagefile.getBytes());
//////			fileOutputStream.close();
//////		} catch (FileNotFoundException e) {
//////			e.printStackTrace();
//////		} catch (Exception e) {
//////			e.printStackTrace();
//////		}
//////
//////		product.setImage(avatarFileName);
////		
////		if(imagefile != null && imagefile.getSize() > 0) {
////			try {
////				final String folder = "D:/JavaCore/BookStore/picture/upload";
////				String originFilename = imagefile.getOriginalFilename();
////			
////				File newFile = new File(folder + "/" +originFilename);
////			
////				// copy noi dung file upload vao file new
////				imagefile.transferTo(newFile);
////				
////				//luu lai vao db
////				product.setImage(originFilename);
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
////		
////		productService.update(product);
////
////		return "redirect:/admin/product/search";
////	} 
////
////	@GetMapping(value = "/admin/product/delete")
////	public String delete(@RequestParam(name = "id") int id) {
////		productService.delete(id);
////
////		return "redirect:/admin/product/search";
////	}
////	
//////	@GetMapping(value = "/admin/product/search")
//////	public String search(HttpServletRequest request) {
//////
//////		String thuongHieuName = request.getParameter("thuongHieuName") == null ? "" : request.getParameter("thuongHieuName");
//////		request.setAttribute("thuongHieuName", thuongHieuName);
//////
//////		String kichThuocName = request.getParameter("kichThuocName") == null ? "" : request.getParameter("kichThuocName");
//////		request.setAttribute("kichThuocName", kichThuocName);
//////
//////		String gioiTinhName = request.getParameter("gioiTinhName") == null ? "" : request.getParameter("gioiTinhName");
//////		request.setAttribute("gioiTinhName", gioiTinhName);
//////
//////		String categoryName = request.getParameter("categoryName") == null ? "" : request.getParameter("categoryName");
//////		request.setAttribute("categoryName", categoryName);
//////		
////////		Integer categoryId = request.getParameter("categoryId") == null ?  1 : Integer.valueOf(request.getParameter("categoryId"));
////////		request.setAttribute("categoryId", categoryId);
//////
//////		String keyword = request.getParameter("keyword") == null ? "" : request.getParameter("keyword");
//////		request.setAttribute("keyword", keyword);
//////
//////		Integer page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
//////		request.setAttribute("page", page);
//////
//////		Long priceStart = (request.getParameter("priceStart") == null || request.getParameter("priceStart") == "") ? 1 : Long.valueOf(request.getParameter("priceStart"));
//////
//////		Long priceEnd = (request.getParameter("priceEnd") == null || request.getParameter("priceEnd") == "") ? 100000 : Long.valueOf(request.getParameter("priceEnd"));
//////
////////		List<ProductDTO> listPro = productService.searchByCategory(keyword, thuongHieuName, kichThuocName, gioiTinhName, priceStart, priceEnd, categoryId, 0, page * 10);
////////		request.setAttribute("productList", listPro);
//////		
//////		List<ProductDTO> listPro = productService.search(keyword, categoryName, thuongHieuName, kichThuocName,gioiTinhName,
//////				priceStart, priceEnd, 0, page * 20);
//////		request.setAttribute("productList", listPro);
//////
//////		List<CategoryDTO> listCate = categoryService.search("", 0, page * 10);
//////		request.setAttribute("categoryList", listCate);
//////
//////		List<ThuongHieuDTO> listTH = thuongHieuService.search("", 0, page * 10);
//////		request.setAttribute("thuongHieuList", listTH);
//////
//////		List<KichThuocDTO> listKT = kichThuocService.search("", 0, page * 10); 
//////		request.setAttribute("kichThuocList", listKT);
//////
//////		List<GioiTinhDTO> listGT = gioiTinhService.search("", 0, page * 10);
//////		request.setAttribute("gioiTinhList", listGT);
//////  
//////		return "/admin/product/search";
//////	} 
////	
////	@GetMapping(value = "/admin/product/search")
////	public String AdminProductSearch(HttpServletRequest request) {
////
////		String thuongHieuName = request.getParameter("thuongHieuName") == null ? "" : request.getParameter("thuongHieuName");
////
////		String gioiTinhName = request.getParameter("gioiTinhName") == null ? "" : request.getParameter("gioiTinhName");
////
////		String categoryName = request.getParameter("categoryName") == null ? "" : request.getParameter("categoryName");
////
////		String kichThuocName = request.getParameter("kichThuocName") == null ? "" : request.getParameter("kichThuocName");
////
////		String keyword = request.getParameter("keyword") == null ? "" : request.getParameter("keyword");
////
////		Integer page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
////
////		Long priceStart = (request.getParameter("priceStart") == null || request.getParameter("priceStart") == "") ? 1
////				: Long.valueOf(request.getParameter("priceStart"));
////
////		Long priceEnd = (request.getParameter("priceEnd") == null || request.getParameter("priceEnd") == "") ? 100000
////				: Long.valueOf(request.getParameter("priceEnd"));
////
////		List<ProductDTO> listPro = productService.search(keyword,categoryName, thuongHieuName, kichThuocName,gioiTinhName,
////			priceStart, priceEnd, 0, page * 10);
////		List<CategoryDTO> categoryDTOs = categoryService.search("", 0, page * 10);
////		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.search("", 0, page * 10);
////		List<KichThuocDTO> kichThuocDTOs = kichThuocService.search("", 0, page * 10);
////		List<GioiTinhDTO> gioiTinhDTOs = gioiTinhService.search("", 0, page * 10);
////
////		request.setAttribute("gioiTinhList", gioiTinhDTOs);
////		request.setAttribute("kichThuocList", kichThuocDTOs);
////		request.setAttribute("thuongHieuList", thuongHieuDTOs);
////		request.setAttribute("productList", listPro);
////		request.setAttribute("categoryList", categoryDTOs);
////
////		request.setAttribute("gioiTinhName", gioiTinhName);
////		request.setAttribute("kichThuocName", kichThuocName);
////		request.setAttribute("categoryName", categoryName);
////		request.setAttribute("thuongHieuName", thuongHieuName);
////		request.setAttribute("page", page);
////		request.setAttribute("keyword", keyword);
////		return "admin/product/search";
////	}
////	
////	@GetMapping("/admin/product/download")
////	public void download(@RequestParam("image") String image
////			, HttpServletResponse response) {
////		final String folder = "D:/JavaCore/BookStore/picture/upload";
////		
////		File file = new File(folder + "/" + image);
////		if(file.exists()) {
////			try {
////				Files.copy(file.toPath(), response.getOutputStream());
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
////		}
////	}
////} 
//
//
//
//package com.example.demo.controller;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.example.demo.model.CategoryDTO;
//import com.example.demo.model.GioiTinhDTO;
//import com.example.demo.model.KichThuocDTO;
//import com.example.demo.model.ProductDTO;
//import com.example.demo.model.ThuongHieuDTO;
//import com.example.demo.service.CategoryService;
//import com.example.demo.service.GioiTinhService;
//import com.example.demo.service.KichThuocService;
//import com.example.demo.service.ProductService;
//import com.example.demo.service.ThuongHieuService;
//
//@Controller
//public class ProductController {
//	@Autowired
//	private ProductService productService;
//	@Autowired
//	private CategoryService categoryService;
//	@Autowired
//	private ThuongHieuService thuongHieuService;
//	@Autowired
//	private KichThuocService kichThuocService;
//	@Autowired
//	private GioiTinhService gioiTinhService;
//
//	@GetMapping(value = "/admin/product/create")
//	public String AdminProductAddGet(HttpServletRequest request, Model model) {
//		model.addAttribute("product", new ProductDTO());
//		List<CategoryDTO> list = categoryService.search("", 0, 100);
//		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.search("", 0, 100);
//		List<KichThuocDTO> kichThuocDTOs = kichThuocService.search("", 0, 100);
//		List<GioiTinhDTO> gioiTinhDTOs = gioiTinhService.search("", 0, 100);
//
//		request.setAttribute("gioiTinhList", gioiTinhDTOs);
//		request.setAttribute("categoryList", list);
//		request.setAttribute("thuongHieuList", thuongHieuDTOs);
//		request.setAttribute("kichThuocList", kichThuocDTOs);
//
//		return "admin/product/create";
//	}
//
//	@PostMapping(value = "/admin/product/create")
//	public String AdminProductAddPost(@ModelAttribute(name = "product") ProductDTO product,
//			@RequestParam(name = "imagefile") MultipartFile imagefile) {
//		
////		String originalFilename = imagefile.getOriginalFilename();
////		int lastIndex = originalFilename.lastIndexOf(".");
////		String ext = originalFilename.substring(lastIndex);
////		String avatarFilename = System.currentTimeMillis() + ext;
////		File newfile = new File("D:\\JavaCore\\StoreSach\\picture\\upload\\" + avatarFilename);
////		FileOutputStream fileOutputStream;
////		try {
////			fileOutputStream = new FileOutputStream(newfile);
////			fileOutputStream.write(imagefile.getBytes());
////			fileOutputStream.close();
////		} catch (FileNotFoundException e) {
////			e.printStackTrace();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////
////		product.setImage(avatarFilename);
//		
//		
//		if(imagefile != null && imagefile.getSize() > 0) {
//			try {
//				final String folder = "D:/JavaCore/StoreSach/picture/upload";
//				String originFilename = imagefile.getOriginalFilename();
//			
//				File newFile = new File(folder + "/" +originFilename);
//			
//				// copy noi dung file upload vao file new
//				imagefile.transferTo(newFile);
//				
//				//luu lai vao db
//				product.setImage(originFilename);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		productService.insert(product);
//		return "redirect:/admin/product/search";
//	}
//
//	@GetMapping(value = "/admin/product/update")
//	public String AdminProductUpdate(HttpServletRequest request, Model model, int id) {
//		ProductDTO product = productService.get(id);
//		List<CategoryDTO> list = categoryService.search("", 0, 100);
//		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.search("", 0, 100);
//		List<KichThuocDTO> kichThuocDTOs = kichThuocService.search("", 0, 100);
//		List<GioiTinhDTO> gioiTinhDTOs = gioiTinhService.search("", 0, 100);
//
//		model.addAttribute("product", product);
//		request.setAttribute("gioiTinhList", gioiTinhDTOs);
//		request.setAttribute("categoryList", list);
//		request.setAttribute("thuongHieuList", thuongHieuDTOs);
//		request.setAttribute("kichThuocList", kichThuocDTOs);
//		return "admin/product/update";
//	} 
//
//	@PostMapping(value = "/admin/product/update")
//	public String AdminProductUpdate(@ModelAttribute(name = "product") ProductDTO product,
//			@RequestParam(name = "imagefile") MultipartFile imagefile) {
//		
//		 
////		String originalFilename = imagefile.getOriginalFilename();
////		int lastIndex = originalFilename.lastIndexOf(".");
////		String ext = originalFilename.substring(lastIndex);
////		String avatarFilename = System.currentTimeMillis() + ext;
////		File newfile = new File("D:\\JavaCore\\StoreSach\\picture\\upload" + avatarFilename);
////		FileOutputStream fileOutputStream;
////		try {
////			fileOutputStream = new FileOutputStream(newfile);
////			fileOutputStream.write(imagefile.getBytes());
////			fileOutputStream.close();
////		} catch (FileNotFoundException e) {
////			e.printStackTrace();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//// 
////		product.setImage(avatarFilename);
//		
//		if(imagefile != null && imagefile.getSize() > 0) {
//			try {
//				final String folder = "D:/JavaCore/StoreSach/picture/upload";
//				String originFilename = imagefile.getOriginalFilename();
//			
//				File newFile = new File(folder + "/" +originFilename);
//			
//				// copy noi dung file upload vao file new
//				imagefile.transferTo(newFile);
//				
//				//luu lai vao db
//				product.setImage(originFilename);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}  
//		}
//		
//		productService.update(product);
//		return "redirect:/admin/product/search";
//	}
//
//	@GetMapping(value = "/admin/product/delete")
//	public String AdminDeleteProduct(@RequestParam(name = "id") int id) {
//		productService.delete(id);
//		return "redirect:/admin/product/search";
//	}
//
//	@GetMapping(value = "/admin/product/search")
//	public String AdminProductSearch(HttpServletRequest request) {
//
//		String thuongHieuName = request.getParameter("thuongHieuName") == null ? "" : request.getParameter("thuongHieuName");
//
//		String gioiTinhName = request.getParameter("gioiTinhName") == null ? "" : request.getParameter("gioiTinhName");
//
//		String categoryName = request.getParameter("categoryName") == null ? "" : request.getParameter("categoryName");
//
//		String kichThuocName = request.getParameter("kichThuocName") == null ? "" : request.getParameter("kichThuocName");
//
//		String keyword = request.getParameter("keyword") == null ? "" : request.getParameter("keyword");
//
//		Integer page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
//
//		Long priceStart = (request.getParameter("priceStart") == null || request.getParameter("priceStart") == "") ? 1
//				: Long.valueOf(request.getParameter("priceStart"));
//
//		Long priceEnd = (request.getParameter("priceEnd") == null || request.getParameter("priceEnd") == "") ? 1000000
//				: Long.valueOf(request.getParameter("priceEnd"));
//
//		List<CategoryDTO> categoryDTOs = categoryService.search("", 0, page * 20);
//		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.search("", 0, page * 20);
//		List<KichThuocDTO> kichThuocDTOs = kichThuocService.search("", 0, page * 20);
//		List<GioiTinhDTO> gioiTinhDTOs = gioiTinhService.search("", 0, page * 20);
//		List<ProductDTO> productDTOs = productService.search(keyword,categoryName, thuongHieuName, kichThuocName,gioiTinhName,
//				priceStart, priceEnd, 0, page * 20);
//
//		request.setAttribute("gioiTinhList", gioiTinhDTOs);
//		request.setAttribute("kichThuocList", kichThuocDTOs);
//		request.setAttribute("thuongHieuList", thuongHieuDTOs);
//		request.setAttribute("productList", productDTOs);
//		request.setAttribute("categoryList", categoryDTOs);
//
//		request.setAttribute("gioiTinhName", gioiTinhName);
//		request.setAttribute("kichThuocName", kichThuocName);
//		request.setAttribute("categoryName", categoryName);
//		request.setAttribute("thuongHieuName", thuongHieuName);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		
////		if(size == null) {
////			size = 10;
////		}
////		
////		if(page == null) {
////			page = 0;
////		}
////		
////		List<CategoryDTO> categoryDTOs = categoryService.search("", 0, page * 10);
////		model.addAttribute("categoryList", categoryDTOs);
////		
////		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.search("", 0, page * 10);
////		model.addAttribute("thuongHieuList", thuongHieuDTOs);
////		
////		List<KichThuocDTO> kichThuocDTOs = kichThuocService.search("", 0, page * 10);
////		model.addAttribute("kichThuocList", kichThuocDTOs);
////		
////		List<GioiTinhDTO> gioiTinhDTOs = gioiTinhService.search("", 0, page * 10);
////		model.addAttribute("gioiTinhList", gioiTinhDTOs);
////		
////		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
////		
////		Page<ProductDTO> pageProduct = productService.search(gioiTinhName, categoryName, thuongHieuName, kichThuocName, gioiTinhName, priceStart, priceEnd, 0, page * 10); 
//		return "admin/product/search";
//	}
//	
//	@GetMapping(value = "/download")
//	public void download(HttpServletResponse response, @RequestParam("image") String image) {
////		final String uploadFolder = "D:\\JavaCore\\BookStore\\picture\\upload";
//		
//		final String uploadFolder = "D:/JavaCore/StoreSach/picture/upload";
//		File file = new File(uploadFolder + "/" + image);
//		if (file.exists()) {
//			try {
//				Files.copy(file.toPath(), response.getOutputStream());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
////	@GetMapping("/admin/product/download")
////	public void download(@RequestParam("image") String image
////			, HttpServletResponse response) {
////		final String folder = "D:/JavaCore/BookStore/picture/upload";
////		
////		File file = new File(folder + "/" + image);
////		if(file.exists()) {
////			try {
////				Files.copy(file.toPath(), response.getOutputStream());
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
////		}
////	}
//}