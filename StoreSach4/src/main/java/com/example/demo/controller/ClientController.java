////package com.example.demo.controller;
////
////import java.util.ArrayList;
////import java.util.Arrays;
////import java.util.HashMap;
////import java.util.LinkedList;
////import java.util.List;
////import java.util.Map;
////import java.util.Scanner;
////
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpSession;
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
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////
////import com.example.demo.entity.BillItems;
////import com.example.demo.entity.Category;
////import com.example.demo.entity.Product;
////import com.example.demo.entity.ProductSize;
////import com.example.demo.entity.Size;
////import com.example.demo.repository.ProductRepo;
////import com.example.demo.repository.ProductSizeRepo;
////import com.example.demo.repository.SizeRepo;
////import com.example.demo.service.ProductService;
////
////@Controller
////public class ClientController {
////	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
////	@Autowired
////	ProductRepo productRepo;
////
////	@Autowired
////	SizeRepo sizeRepo;
////
////	@Autowired
////	ProductSizeRepo productSizeRepo;
//// 
////	@Autowired
////	ProductService productService;
////
////	@GetMapping("")
////	public String home() {
////		return "client/home";
////	}
////
//////	@PostMapping("/login")
//////	public String login() {
//////		return "client/login";
//////	}
////
//////	@GetMapping(value = "/register")
//////	public String register() {
//////		return "client/register";
//////	}
////
////	@GetMapping("/polo")
////	public String poloNam(Model model,
//////			@RequestParam(name = "id", required = false) Integer id ,
////			@RequestParam(name = "name", required = false) String name,
//////			@RequestParam(name = "categoryID", required = false) Integer categoryID ,
////			@RequestParam(name = "page", required = false) Integer page,
////			@RequestParam(name = "size", required = false) Integer size) {
////
////		if (size == null) { 
////			size = 12;
////		}
////
////		if (page == null) {
////			page = 0;
////		}
////
////		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
////
////		if (name != null && !name.isEmpty()) {
////			Page<Product> pageProduct = productRepo.searchNameP("%" + name + "%", pageable);
////			model.addAttribute("list", pageProduct.toList());
////			model.addAttribute("totalPage", pageProduct.getTotalPages());
////		} else {
////			Page<Product> pageProduct = productRepo.findAll(pageable);
////			model.addAttribute("list", pageProduct.toList());
////			model.addAttribute("totalPage", pageProduct.getTotalPages());
////		}
////
////		model.addAttribute("page", page);
////		model.addAttribute("size", size);
////		model.addAttribute("name", name == null ? "" : name);
////		return "client/polo-nam";
////	}
////
////	@GetMapping("/product")
////	public String product(Model model, HttpServletRequest request,
////			@RequestParam(name = "id", required = true) Integer id) {
////
////	 	Product product = productRepo.getById(id); 
////		request.setAttribute("product", product);
////
////		 
////		List<ProductSize> productSizes = productSizeRepo.findSizes(id);
////		model.addAttribute("productSizes", productSizes);
////		
////		return "client/product";
////	}
////	
////	@GetMapping("/cart")
////	public String cart(@RequestParam(name = "id", required = true) Integer id, HttpSession session) {
////		Product product = productRepo.getById(id);
////		
//////		ProductSize productSize = productSizeRepo.getById(id);
////		
////		List<ProductSize> productSizes = (List<ProductSize>) productSizeRepo.getById(product.getId());
////		
////		Object object = session.getAttribute("cart");
////		
//////		Scanner sc1 = new Scanner(System.in);
//////		int n = sc1.nextInt(); 
////		// neu cart rong
////		if(object == null) {
////			BillItems billItems = new BillItems();
////			billItems.setProduct(product); // them sp vao cart
////			billItems.setQuantity(1); 
////			billItems.setBuyPrice(product.getPrice());
////			Map<Integer, BillItems> map = new HashMap<Integer, BillItems>();
////			map.put(id, billItems);
////			session.setAttribute("cart", map); // set cart bang map
////		} else { // neu cart da co sp
////			Map<Integer, BillItems> map = (Map<Integer, BillItems>) object; // lay map ra
////			BillItems billItems = map.get(id); // tim danh sach sp co trong map
////			if(billItems == null) { // neu chua co sp trong map thi lay thong tin sp va sl sp = 1
////				billItems = new BillItems();
////				billItems.setProduct(product);
////				billItems.setQuantity(1);
////				billItems.setBuyPrice(product.getPrice());
////				map.put(id, billItems); 
////			}   
//////			else { // neu co sp trong map roi thi tang so luong cua sp len +1
////////				ProductSize productSize = new ProductSize(); 
//////				if(billItems.getQuantity() < productSizes.get(product.getId()).getSize().getQuantity()) {
//////					billItems.setQuantity(billItems.getQuantity() + 1);
//////				} else {
//////					billItems.setQuantity(billItems.getQuantity());
//////				}
//////			}
////			session.setAttribute("cart", map);
////		}
////		return "client/cart"; 
////	} 
////}
//
//
//package com.example.demo.controller;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.model.BillProductDTO;
//import com.example.demo.model.CategoryDTO;
//import com.example.demo.model.CommentDTO;
//import com.example.demo.model.GioiTinhDTO;
//import com.example.demo.model.KichThuocDTO;
//import com.example.demo.model.ProductDTO;
//import com.example.demo.model.ReviewDTO;
//import com.example.demo.model.ThuongHieuDTO;
//import com.example.demo.model.UserDTO;
//import com.example.demo.service.CategoryService;
//import com.example.demo.service.CommentService;
//import com.example.demo.service.GioiTinhService;
//import com.example.demo.service.KichThuocService;
//import com.example.demo.service.ProductService;
//import com.example.demo.service.ReviewService;
//import com.example.demo.service.ThuongHieuService;
//import com.example.demo.service.UserService;
//import com.example.demo.utils.RoleEnum;
//
//@Controller
//public class ClientController {
//
//	@Autowired
//	private CommentService commentService;
//
//	@Autowired
//	private ProductService productService;
//
//	@Autowired
//	private CategoryService categoryService;
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private ReviewService reviewService;
//
//	@Autowired
//	private ThuongHieuService thuongHieuService;
//
//	@Autowired
//	private KichThuocService kichThuocService;
//
//	@Autowired
//	private GioiTinhService gioiTinhService;
//
//	@GetMapping(value = "/login")
//	public String login(HttpServletRequest request, 
//			@RequestParam(name = "err", required = false) String error) {
//		if (error != null) {
//			request.setAttribute("err", error);
//		}
//		return "client/login";
//	}
//
//	@GetMapping(value = "/register")
//	public String register(HttpServletRequest request) {
//		return "client/register";
//	}
//	
////	@GetMapping(value = "/products2")
////	public String products2(HttpServletRequest request) {
////		String gioiTinhName = request.getParameter("gioiTinhName") == null ? "" : request.getParameter("gioiTinhName");
////		String thuongHieuName = request.getParameter("thuongHieuName") == null ? ""
////				: request.getParameter("thuongHieuName");
////		String categoryName = request.getParameter("categoryName") == null ? "" : request.getParameter("categoryName");
////
////		String kichThuocName = request.getParameter("kichThuocName") == null ? ""
////				: request.getParameter("kichThuocName");
////
////		String keyword = request.getParameter("keyword") == null ? "" : request.getParameter("keyword");
////
////		Long priceStart = (request.getParameter("priceStart") == null || request.getParameter("priceStart") == "") ? 1
////				: Long.valueOf(request.getParameter("priceStart"));
////
////		Integer page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
////
////		Long priceEnd = (request.getParameter("priceEnd") == null || request.getParameter("priceEnd") == "") ? 1000000
////				: Long.valueOf(request.getParameter("priceEnd"));
////
////		List<ProductDTO> listPro = productService.search(keyword, categoryName, thuongHieuName,kichThuocName, gioiTinhName, priceStart, priceEnd, 0, page * 10);
////
////		List<CategoryDTO> list = categoryService.search("", 0, page * 10);
////		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.search("", 0, page * 10);
////		List<KichThuocDTO> kichThuocDTOs = kichThuocService.search("", 0, page * 10);
////		List<GioiTinhDTO> gioiTinhDTOs = gioiTinhService.search("", 0, page * 10);
////
////		request.setAttribute("gioiTinhList", gioiTinhDTOs);
////		request.setAttribute("kichThuocList", kichThuocDTOs);
////		request.setAttribute("thuongHieuList", thuongHieuDTOs);
////		request.setAttribute("productList", listPro);
////		request.setAttribute("categoryList", list);
////
////		request.setAttribute("gioiTinhName", gioiTinhName);
////		request.setAttribute("kichThuocName", kichThuocName);
////		request.setAttribute("categoryName", categoryName);
////		request.setAttribute("thuongHieuName", thuongHieuName);
////		request.setAttribute("page", page);
////		request.setAttribute("keyword", keyword);
////		return "client/bookstore/products";
////	}
//
//	@PostMapping(value = "/register")
//	public String register(@ModelAttribute UserDTO userDTO) {
//		userDTO.setEnabled(true);
//		userDTO.setRole(RoleEnum.MEMBER.getRoleName());
//		userService.insert(userDTO);
//		return "redirect:/login";
//	}
//
//	@GetMapping(value = "/products")
//	public String findProducts(HttpServletRequest request) {
//
//		String gioiTinhName = request.getParameter("gioiTinhName") == null ? "" : request.getParameter("gioiTinhName");
//		String thuongHieuName = request.getParameter("thuongHieuName") == null ? ""
//				: request.getParameter("thuongHieuName");
//		String categoryName = request.getParameter("categoryName") == null ? "" : request.getParameter("categoryName");
//
//		String kichThuocName = request.getParameter("kichThuocName") == null ? ""
//				: request.getParameter("kichThuocName");
//
//		String keyword = request.getParameter("keyword") == null ? "" : request.getParameter("keyword");
//
//		Long priceStart = (request.getParameter("priceStart") == null || request.getParameter("priceStart") == "") ? 1
//				: Long.valueOf(request.getParameter("priceStart"));
//
//		Integer page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
//
//		Long priceEnd = (request.getParameter("priceEnd") == null || request.getParameter("priceEnd") == "") ? 1000000
//				: Long.valueOf(request.getParameter("priceEnd"));
//
//		List<ProductDTO> listPro = productService.search(keyword, categoryName, thuongHieuName,kichThuocName, gioiTinhName, priceStart, priceEnd, 0, page * 10);
//
//		List<CategoryDTO> list = categoryService.search("", 0, page * 10);
//		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.search("", 0, page * 10);
//		List<KichThuocDTO> kichThuocDTOs = kichThuocService.search("", 0, page * 10);
//		List<GioiTinhDTO> gioiTinhDTOs = gioiTinhService.search("", 0, page * 10);
//
//		request.setAttribute("gioiTinhList", gioiTinhDTOs);
//		request.setAttribute("kichThuocList", kichThuocDTOs);
//		request.setAttribute("thuongHieuList", thuongHieuDTOs);
//		request.setAttribute("productList", listPro);
//		request.setAttribute("categoryList", list);
//
//		request.setAttribute("gioiTinhName", gioiTinhName);
//		request.setAttribute("kichThuocName", kichThuocName);
//		request.setAttribute("categoryName", categoryName);
//		request.setAttribute("thuongHieuName", thuongHieuName);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		return "client/products";
//	}
//	
//	@GetMapping(value = "/product")
//	public String oneProduct(HttpServletRequest request, @RequestParam(name = "id", required = true) Integer id) {
//		ProductDTO product = productService.get(id);
//		List<CommentDTO> commentDTOs = commentService.searchByProduct(id);
//		List<ReviewDTO> reviews = reviewService.find(id);
//		float sum=0;
//		for(ReviewDTO reviewDTO:reviews) {
//			int star=reviewDTO.getStarNumber(); 
//			sum=sum+star; 
//		} 
//		int dem=reviews.size();
//		float totalStar= sum/dem;
//		request.setAttribute("dem", dem);
//		request.setAttribute("totalStar", totalStar);
//		request.setAttribute("product", product);
//		request.setAttribute("commentProduct", commentDTOs);
//		request.setAttribute("reviews", reviews);
//		return "client/product";
//	}
// 
////	@GetMapping(value = "/product2")
////	public String oneProduct2(HttpServletRequest request, @RequestParam(name = "id", required = true) Integer id) {
////		ProductDTO product = productService.get(id);
////		List<CommentDTO> commentDTOs = commentService.searchByProduct(id);
////		List<ReviewDTO> reviews = reviewService.find(id);
////		float sum=0;
////		for(ReviewDTO reviewDTO:reviews) {
////			int star=reviewDTO.getStarNumber();
////			sum=sum+star; 
////		} 
////		int dem=reviews.size();
////		float totalStar= sum/dem;
////		request.setAttribute("dem", dem);
////		request.setAttribute("totalStar", totalStar);
////		request.setAttribute("product", product);
////		request.setAttribute("commentProduct", commentDTOs);
////		request.setAttribute("reviews", reviews);
////		return "client/bookstore/product";
////	}
//
////	@GetMapping(value = "/member/add-to-cart")
////	public String AddToCart(@RequestParam(name = "pid") Integer pId, HttpSession session) throws IOException {
////		ProductDTO product = productService.get(pId);// lay thong tin sp tu trang products , product
////	
////		Object object = session.getAttribute("cart");// lay session neu co , neu chua co tao 1 session moi la cart
////		if (object == null) {// neu cart rong 
////			BillProductDTO billProduct = new BillProductDTO();
////			billProduct.setProductDTO(product);// them sp vao cart
////			billProduct.setQuantity(1);// sl sp =1
////			billProduct.setUnitPrice(product.getPrice());
////			Map<Integer, BillProductDTO> map = new HashMap<>();// luu tt sp vao map
////			map.put(pId, billProduct);
////			session.setAttribute("cart", map);// set cart bang map
////		} else {// neu cart da co sp
////			Map<Integer, BillProductDTO> map = (Map<Integer, BillProductDTO>) object;// lay ra map 
////			BillProductDTO billProduct = map.get(pId);// tim danh sach sp co trong map
////			if (billProduct == null) {// neu chua co sp trong map thi lay tt sp va sl sp =1
////				billProduct = new BillProductDTO();
////				billProduct.setProductDTO(product);
////				billProduct.setQuantity(1);
////				billProduct.setUnitPrice(product.getPrice());
////				map.put(pId, billProduct);
////			} else {// neu co sp trong map roi thi tang sl cua sp len +1
////				
////				if (billProduct.getQuantity() < product.getSoLuong()) {
////					billProduct.setQuantity(billProduct.getQuantity() + 1);
////				} else {
////					billProduct.setQuantity(billProduct.getQuantity());
////				}
////			}
////			session.setAttribute("cart", map);
////		}
////		return "redirect:/cart";
////	}
//	
////	@GetMapping(value = "/member/add-to-cart2")
////	public String AddToCart2(@RequestParam(name = "pid") Integer pId, HttpSession session) throws IOException {
////		ProductDTO product = productService.get(pId);// lay thong tin sp tu trang products , product
////	
////		Object object = session.getAttribute("cart");// lay session neu co , neu chua co tao 1 session moi la cart
////		if (object == null) {// neu cart rong 
////			BillProductDTO billProduct = new BillProductDTO();
////			billProduct.setProductDTO(product);// them sp vao cart
////			billProduct.setQuantity(1);// sl sp =1
////			billProduct.setUnitPrice(product.getPrice());
////			Map<Integer, BillProductDTO> map = new HashMap<>();// luu tt sp vao map
////			map.put(pId, billProduct);
////			session.setAttribute("cart", map);// set cart bang map
////		} else {// neu cart da co sp
////			Map<Integer, BillProductDTO> map = (Map<Integer, BillProductDTO>) object;// lay ra map 
////			BillProductDTO billProduct = map.get(pId);// tim danh sach sp co trong map
////			if (billProduct == null) {// neu chua co sp trong map thi lay tt sp va sl sp =1
////				billProduct = new BillProductDTO();
////				billProduct.setProductDTO(product);
////				billProduct.setQuantity(1);
////				billProduct.setUnitPrice(product.getPrice());
////				map.put(pId, billProduct);
////			} else {// neu co sp trong map roi thi tang sl cua sp len +1
////				
////				if (billProduct.getQuantity() < product.getSoLuong()) {
////					billProduct.setQuantity(billProduct.getQuantity() + 1);
////				} else {
////					billProduct.setQuantity(billProduct.getQuantity());
////				}
////			}
////			session.setAttribute("cart", map);
////		}
////		return "redirect:/cart2";
////	}
//	
//	@GetMapping(value = "/delete-from-cart")
//	public String Deletefromtocart(HttpServletRequest req, @RequestParam(name = "key", required = true) Long key) {
//		HttpSession session = req.getSession();
//		Object object = session.getAttribute("cart");
//		if (object != null) {
//			Map<Long, BillProductDTO> map = (Map<Long, BillProductDTO>) object;
//			map.remove(key);
//			session.setAttribute("cart", map);
//		}
//		return "redirect:/cart";
//	} 
//	
//	@GetMapping(value = "/cart")
//	public String cart(HttpSession session) {
//		if(session.getAttribute("cart") == null) {
//			return "client/cart_empty";
//		}
//		return "client/cart";
//	} 
//	
//	@GetMapping(value = "/cart2")
//	public String cart2() {
//		return "client/bookstore/cart";
//	} 
//
//	@GetMapping(value = "/category/search")
//	public String searchCategory(HttpServletRequest request,
//			@RequestParam(value = "keyword", required = false) String keyword,
//			@RequestParam(value = "page", required = false) Integer page) {
//		page = page == null ? 1 : page;
//		keyword = keyword == null ? "" : keyword; 
//		// mac dinh 10 ban ghi 1 trang
//		List<CategoryDTO> categoryList = categoryService.search(keyword, 0, page * 10);
//		request.setAttribute("categoryList", categoryList);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//
//		return "client/bookstore/categories";
//	}
// 
//	@GetMapping(value = "/productsByCategory")
//	public String AdminProductSearch(HttpServletRequest request,
//			@RequestParam(name = "categoryId", required = false) Integer categoryId) {
//
//		String thuongHieuName = request.getParameter("thuongHieuName") == null ? ""
//				: request.getParameter("thuongHieuName");
//
//		String gioiTinhName = request.getParameter("gioiTinhName") == null ? "" : request.getParameter("gioiTinhName");
//		
//		String kichThuocName = request.getParameter("kichThuocName") == null ? ""
//				: request.getParameter("kichThuocName");
//		
//		String keyword = request.getParameter("keyword") == null ? "" : request.getParameter("keyword");
//		Integer page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
//
//		Long priceStart = (request.getParameter("priceStart") == null || request.getParameter("priceStart") == "") ? 1
//				: Long.valueOf(request.getParameter("priceStart"));
//		Long priceEnd = (request.getParameter("priceEnd") == null || request.getParameter("priceEnd") == "") ? 100000
//				: Long.valueOf(request.getParameter("priceEnd"));
//
//		List<ProductDTO> listPro = productService.searchByCategory(keyword, thuongHieuName,
//				kichThuocName, gioiTinhName, priceStart, priceEnd, categoryId, 0, page*10);
//		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.search("", 0, page * 10);
//		List<KichThuocDTO> kichThuocDTOs = kichThuocService.search("", 0, page * 10);
//		List<GioiTinhDTO> gioiTinhDTOs = gioiTinhService.search("", 0, page * 10);
//
//		request.setAttribute("gioiTinhList", gioiTinhDTOs); 
//		request.setAttribute("kichThuocList", kichThuocDTOs);
//		request.setAttribute("thuongHieuList", thuongHieuDTOs);
//		request.setAttribute("productList", listPro);
//
//		request.setAttribute("kichThuocName", kichThuocDTOs);
//		request.setAttribute("thuongHieuName", thuongHieuName);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		return "client/products-by-category";
//	}
//}