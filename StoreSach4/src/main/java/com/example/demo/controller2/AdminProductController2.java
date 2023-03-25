package com.example.demo.controller2;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity2.Category;
import com.example.demo.entity2.Coupon;
import com.example.demo.entity2.GioiTinh;
import com.example.demo.entity2.KichThuoc;
import com.example.demo.entity2.Product;
import com.example.demo.entity2.ThuongHieu;
import com.example.demo.service2.Cate_TH_KT_GT_Coupon_Service;
import com.example.demo.service2.ProductService2;

@Controller
public class AdminProductController2 {
	
	@Autowired
	private ProductService2 productService;
	
	@Autowired
	private Cate_TH_KT_GT_Coupon_Service service;
	
	@GetMapping("/admin/category/search")
	public String searchCate(Model model)
	{
		List<Category> categories = service.getAllCategory();
		model.addAttribute("categories", categories);
		return "/admin/category/search"; 
	} 
	
	@GetMapping("/admin/thuong-hieu/search")
	public String searchTH(Model model) {
		List<ThuongHieu> thuongHieus = service.getAllThuongHieu();
		model.addAttribute("thuongHieus", thuongHieus);
		return "/admin/thuong-hieu/search"; 
	}
	
	@GetMapping("/admin/kich-thuoc/search")
	public String searchKT(Model model)
	{
		List<KichThuoc> kichThuocs = service.getAllKichThuoc();
		model.addAttribute("kichThuocs", kichThuocs);
		return "/admin/kich-thuoc/search"; 
	}
	
	@GetMapping("/admin/gioi-tinh/search")
	public String searchGT(Model model)
	{
		List<GioiTinh> gioiTinhs = service.getAllGioiTinh();
		model.addAttribute("gioiTinhs", gioiTinhs);
		return "/admin/gioi-tinh/search"; 
	}
	
	@GetMapping("/admin/coupon/search")
	public String searchCoupon(Model model)
	{
		List<Coupon> coupons = service.getAllCoupon();
		model.addAttribute("coupons", coupons);
		return "/admin/coupon/search"; 
	}
	
	@GetMapping("/admin/product/search")
	public String showExampleView(Model model, @RequestParam(name = "id", required = false) Long id)
	{
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		
		List<Category> categories = service.getAllCategory();
		model.addAttribute("categories", categories);
		
		List<ThuongHieu> thuongHieus = service.getAllThuongHieu();
		model.addAttribute("thuongHieus", thuongHieus);
		
		List<KichThuoc> kichThuocs = service.getAllKichThuoc();
		model.addAttribute("kichThuocs", kichThuocs);
		
		List<GioiTinh> gioiTinhs = service.getAllGioiTinh();
		model.addAttribute("gioiTinhs", gioiTinhs);
		
		return "/admin/index";  
	} 
	
    @GetMapping("/admin/product")
    public String showAddProduct(Model model)
    {
    	model.addAttribute("category", new Category());
    	model.addAttribute("categories", productService.getAllCategories());
    	
    	model.addAttribute("thuongHieu", new ThuongHieu());
    	model.addAttribute("thuongHieus", productService.getAllThuongHieus());
    	
    	model.addAttribute("kichThuoc", new KichThuoc());
    	model.addAttribute("kichThuocs", productService.getAllKichThuocs());
    	
    	model.addAttribute("gioiTinh", new GioiTinh());
    	model.addAttribute("gioiTinhs", productService.getAllGioiTinhs());
    	
    	model.addAttribute("products", productService.getAllProduct());
    	return "/admin/product";
    }
    
    @PostMapping("/admin/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") Double price,
    		@RequestParam("desc") String desc,
    		@RequestParam("quantity") int quantity,
    		@RequestParam("brand") String brand,
    		@RequestParam("categories") String categories,
    		@RequestParam("thuongHieus") String thuongHieus,
    		@RequestParam("kichThuocs") String kichThuocs,
    		@RequestParam("gioiTinhs") String gioiTinhs)
    {
    	 
    	productService.saveProductToDB(file, name, desc,quantity, price,brand,categories, thuongHieus, kichThuocs, gioiTinhs);
    	return "redirect:/admin/product";
    }
    
    @GetMapping("/admin/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	
    	productService.deleteProductById(id);
    	return "redirect:/admin/product/search";
    }
    
    @PostMapping("/admin/changeName")
    public String changePname(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name)
    {
    	productService.chageProductName(id, name);
    	return "redirect:/admin/product/search";
    }
    @PostMapping("/admin/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
    		@RequestParam("newDescription") String description)
    {
    	productService.changeProductDescription(id, description);
    	return "redirect:/admin/product/search";
    }
    
    @PostMapping("/admin/changePrice") 
    public String changePrice(@RequestParam("id") Long id ,
    		@RequestParam("newPrice") Double price)
    {
    	
    	productService.changeProductPrice(id, price);
    	return "redirect:/admin/product/search";
    }
    @PostMapping("/admin/changeQuantity")
    public String changeQuantity(@RequestParam("id") Long id ,
    		@RequestParam("newQuantity") int quantity)
    {
    	 
    	productService.changeProductQuantity(id, quantity);
    	return "redirect:/admin/product/search";
    }
    
    @PostMapping("/admin/changeDiscount")
    public String changeDiscount(@RequestParam("id") Long id ,
    		@RequestParam("newDiscount") int discount)
    {
    	
    	productService.changeProductDiscount(id, discount);
    	return "redirect:/admin/product/search";
    }
    
    @PostMapping("/admin/addCategory")
    public String addCategory(@ModelAttribute Category category , Model model) {
    	productService.saveCategory(category);
    	return "redirect:/admin/product";
    }
    
    @PostMapping("/admin/addThuongHieu")
    public String addThuongHieu(@ModelAttribute ThuongHieu thuongHieu , Model model) {
    	productService.saveThuongHieu(thuongHieu);
    	return "redirect:/admin/product";
    }
    
    @PostMapping("/admin/addKichThuoc")
    public String addKichThuoc(@ModelAttribute KichThuoc kichThuoc , Model model) {
    	productService.saveKichThuoc(kichThuoc);
    	return "redirect:/admin/product";
    }
    
    @PostMapping("/admin/addGioiTinh")
    public String addGioiTinh(@ModelAttribute GioiTinh gioiTinh , Model model) {
    	productService.saveGioiTinh(gioiTinh);
    	return "redirect:/admin/product";
    }
    @PostMapping("/admin/addPictureToP")
    public String addImageToProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("product_id") Long id ) {
    	productService.addImageToProduct(file,id);
    	return "redirect:/admin/product";
    }
    @PostMapping("/admin/addDiscountToP")
    public String addDiscountToproduct(@RequestParam("product_id") Long id ,
    		@RequestParam("discount") int discount) {
    	productService.saveProductDicount(id,discount);
    	return "redirect:/admin/product";
    }
}
