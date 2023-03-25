//package com.example.demo.service.impl;
//
////import java.util.ArrayList;
////import java.util.List;
////
////import javax.transaction.Transactional;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import com.example.demo.dao.ProductDao;
////import com.example.demo.entity.Category;
////import com.example.demo.entity.GioiTinh;
////import com.example.demo.entity.KichThuoc;
////import com.example.demo.entity.Product;
////import com.example.demo.entity.ThuongHieu;
////import com.example.demo.model.CategoryDTO;
////import com.example.demo.model.GioiTinhDTO;
////import com.example.demo.model.KichThuocDTO;
////import com.example.demo.model.ProductDTO;
////import com.example.demo.model.ThuongHieuDTO;
////import com.example.demo.service.ProductService;
////
////@Transactional
////@Service
////public class ProductServiceImpl implements ProductService {
////	
////	@Autowired
////	private ProductDao productDao;
////
//////	@Override
//////	public void insert(ProductDTO productDTO) {
//////		Product product = new Product();
//////		product.setName(productDTO.getName());
//////		product.setPrice(productDTO.getPrice());
//////		product.setImage(productDTO.getImage());
//////		product.setDescription(productDTO.getDescription());
//////		product.setSoLuong(productDTO.getSoLuong());
//////		
//////		Category category = new Category();
//////		category.setId(productDTO.getCategory().getId());
//////		category.setNameCategory(productDTO.getCategory().getNameCategory());
//////		product.setCategory(category);
//////		
//////		ThuongHieu thuongHieu = new ThuongHieu();
//////		thuongHieu.setId(productDTO.getThuongHieuDTO().getId());
//////		thuongHieu.setName(productDTO.getThuongHieuDTO().getName());
//////		product.setThuongHieu(thuongHieu);
//////		
//////		KichThuoc kichThuoc = new KichThuoc();
//////		kichThuoc.setId(productDTO.getKichThuocDTO().getId());
//////		kichThuoc.setName(productDTO.getKichThuocDTO().getName());
//////		product.setKichThuoc(kichThuoc);
//////		
//////		GioiTinh gioiTinh = new GioiTinh();
//////		gioiTinh.setId(productDTO.getGioiTinhDTO().getId());
//////		gioiTinh.setName(productDTO.getGioiTinhDTO().getName());
//////		product.setGioiTinh(gioiTinh);
//////		
//////		productDao.insert(product);
////////		productDTO.setId(product.getId());
//////	}
////
//////	@Override
//////	public void update(ProductDTO productDTO) {
//////		Product product = productDao.get(productDTO.getId());
//////		
//////		if (product != null) {
//////			product.setId(productDTO.getId());
//////			product.setName(productDTO.getName());
//////			product.setPrice(productDTO.getPrice());
//////			product.setImage(productDTO.getImage());
//////			product.setDescription(productDTO.getDescription());
//////			product.setSoLuong(productDTO.getSoLuong());
//////			
//////			Category category = new Category();
//////			category.setId(productDTO.getCategory().getId());
//////			category.setNameCategory(productDTO.getCategory().getNameCategory());
//////			product.setCategory(category);
//////			
//////			ThuongHieu thuongHieu = new ThuongHieu();
//////			thuongHieu.setId(productDTO.getThuongHieuDTO().getId());
//////			thuongHieu.setName(productDTO.getThuongHieuDTO().getName());
//////			product.setThuongHieu(thuongHieu);
//////			
//////			KichThuoc kichThuoc = new KichThuoc();
//////			kichThuoc.setId(productDTO.getKichThuocDTO().getId());
//////			kichThuoc.setName(productDTO.getKichThuocDTO().getName());
//////			product.setKichThuoc(kichThuoc);
//////			
//////			GioiTinh gioiTinh = new GioiTinh();
//////			gioiTinh.setId(productDTO.getGioiTinhDTO().getId());
//////			gioiTinh.setName(productDTO.getGioiTinhDTO().getName());
//////			product.setGioiTinh(gioiTinh);
//////			
//////			productDao.update(product);
//////			
//////		}
//////	}
////	
////	@Override
////	public void insert(ProductDTO productDTO) {
////		Product product = new Product();
////		product.setName(productDTO.getName());
////		product.setPrice(productDTO.getPrice());
////		product.setDescription(productDTO.getDescription());
////		product.setImage(productDTO.getImage());
////		product.setSoLuong(productDTO.getSoLuong());
////
////		Category category = new Category();
////		category.setId(productDTO.getCategory().getId());
////		category.setNameCategory(productDTO.getCategory().getNameCategory());
////		product.setCategory(category);
////
////		ThuongHieu thuongHieu = new ThuongHieu();
////		thuongHieu.setId(productDTO.getThuongHieuDTO().getId());
////		thuongHieu.setName(productDTO.getThuongHieuDTO().getName());
////		product.setThuongHieu(thuongHieu);
////
////		KichThuoc kichThuoc = new KichThuoc();
////		kichThuoc.setId(productDTO.getKichThuocDTO().getId());
////		kichThuoc.setName(productDTO.getKichThuocDTO().getName());
////		product.setKichThuoc(kichThuoc);
////
////		GioiTinh gioiTinh = new GioiTinh();
////		gioiTinh.setId(productDTO.getGioiTinhDTO().getId());
////		gioiTinh.setName(productDTO.getGioiTinhDTO().getName());
////		product.setGioiTinh(gioiTinh);
////
////		productDao.insert(product);
////	}
////	
////	@Override
////	public void update(ProductDTO productDTO) {
////		Product product = productDao.get(productDTO.getId());
////		if (product != null) {
////			product.setId(productDTO.getId());
////			product.setName(productDTO.getName());
////			product.setPrice(productDTO.getPrice());
////			product.setDescription(productDTO.getDescription());
////			product.setImage(productDTO.getImage());
////			product.setSoLuong(productDTO.getSoLuong());
////
////			Category category = new Category();
////			category.setId(productDTO.getCategory().getId());
////			category.setNameCategory(productDTO.getCategory().getNameCategory());
////			product.setCategory(category);
////
////			ThuongHieu thuongHieu = new ThuongHieu();
////			thuongHieu.setId(productDTO.getThuongHieuDTO().getId());
////			thuongHieu.setName(productDTO.getThuongHieuDTO().getName());
////			product.setThuongHieu(thuongHieu);
////
////			KichThuoc kichThuoc = new KichThuoc();
////			kichThuoc.setId(productDTO.getKichThuocDTO().getId());
////			kichThuoc.setName(productDTO.getKichThuocDTO().getName());
////			product.setKichThuoc(kichThuoc);
////
////			GioiTinh gioiTinh = new GioiTinh();
////			gioiTinh.setId(productDTO.getGioiTinhDTO().getId());
////			gioiTinh.setName(productDTO.getGioiTinhDTO().getName());
////			product.setGioiTinh(gioiTinh);
////
////			productDao.update(product);
////		}
////	}
////
////	@Override
////	public void delete(int id) {
////		Product product = productDao.get(id);
////		
////		if(product != null) {
////			productDao.delete(product);
////		}
////	}
////
//////	@Override
//////	public ProductDTO get(int id) {
//////		Product product = productDao.get(id);
//////		
//////		ProductDTO dto = new ProductDTO();
//////		dto.setId(product.getId());
//////		dto.setName(product.getName());
//////		dto.setPrice(product.getPrice());
//////		dto.setImage(product.getImage());
//////		dto.setDescription(product.getDescription());
//////		dto.setSoLuong(product.getSoLuong());
//////		
//////		CategoryDTO categoryDTO = new CategoryDTO();
//////		categoryDTO.setId(product.getCategory().getId());
//////		categoryDTO.setNameCategory(product.getCategory().getNameCategory());
//////		dto.setCategory(categoryDTO);
//////		
//////		ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
//////		thuongHieuDTO.setId(product.getThuongHieu().getId());
//////		thuongHieuDTO.setName(product.getThuongHieu().getName());
//////		dto.setThuongHieuDTO(thuongHieuDTO);
//////		
//////		KichThuocDTO productDTO = new KichThuocDTO();
//////		productDTO.setId(product.getKichThuoc().getId());
//////		productDTO.setName(product.getKichThuoc().getName());
//////		dto.setKichThuocDTO(productDTO);
//////		
//////		GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
//////		gioiTinhDTO.setId(product.getGioiTinh().getId());
//////		gioiTinhDTO.setName(product.getGioiTinh().getName());
//////		dto.setGioiTinhDTO(gioiTinhDTO);
//////		
//////		return dto;
//////	}
////
//////	@Override
//////	public List<ProductDTO> search(String findName, String categoryName, String thuongHieuName, String kichThuocName,
//////			String gioiTinhName, Long priceStart, Long priceEnd, int start, int length) {
//////
////////		List<Product> listProducts = productDao.search(findName, categoryName, thuongHieuName, kichThuocName, gioiTinhName, priceStart, priceEnd, start, length);
////////		
////////		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
////////		
////////		for (Product product : listProducts) {
////////			ProductDTO productDTO = new ProductDTO();
////////			productDTO.setId(product.getId());
////////			productDTO.setName(product.getName());
////////			productDTO.setPrice(product.getPrice());
////////			productDTO.setImage(product.getImage());
////////			productDTO.setDescription(product.getDescription());
////////			productDTO.setSoLuong(product.getSoLuong());
////////
////////			CategoryDTO categoryDTO = new CategoryDTO();
////////			categoryDTO.setId(product.getCategory().getId());
//////////			categoryDTO.setName(product.getCategory().getNameCategory());
////////			categoryDTO.setNameCategory(product.getCategory().getNameCategory());
////////			productDTO.setCategory(categoryDTO);
////////
////////			ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
////////			thuongHieuDTO.setId(product.getThuongHieu().getId());
////////			thuongHieuDTO.setName(product.getThuongHieu().getName());
////////			productDTO.setThuongHieuDTO(thuongHieuDTO);
////////
////////			KichThuocDTO kichThuocDTO = new KichThuocDTO();
////////			kichThuocDTO.setId(product.getKichThuoc().getId());
////////			kichThuocDTO.setName(product.getKichThuoc().getName());
////////			productDTO.setKichThuocDTO(kichThuocDTO);
////////
////////			GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
////////			gioiTinhDTO.setId(product.getGioiTinh().getId());
////////			gioiTinhDTO.setName(product.getGioiTinh().getName());
////////			productDTO.setGioiTinhDTO(gioiTinhDTO);
////////
////////			productDTOs.add(productDTO);
////////		}
////////		return productDTOs;
//////		
//////		List<Product> listProducts = productDao.search(findName, categoryName, thuongHieuName, kichThuocName, gioiTinhName,
//////				priceStart, priceEnd, start, length);
//////		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
//////		
//////		for (Product product : listProducts) {
//////			ProductDTO productDTO = new ProductDTO(); 
//////			productDTO.setId(product.getId());
//////			productDTO.setName(product.getName());
//////			productDTO.setPrice(product.getPrice());
//////			productDTO.setImage(product.getImage());
//////			productDTO.setDescription(product.getDescription());
//////			productDTO.setSoLuong(product.getSoLuong());
//////
//////			CategoryDTO categoryDTO = new CategoryDTO();
//////			categoryDTO.setId(product.getCategory().getId());
//////			categoryDTO.setNameCategory(product.getCategory().getNameCategory());
//////			productDTO.setCategory(categoryDTO);
//////
//////			ThuongHieuDTO thuongHieu = new ThuongHieuDTO();
//////			thuongHieu.setId(product.getThuongHieu().getId());
//////			thuongHieu.setName(product.getThuongHieu().getName());
//////			productDTO.setThuongHieuDTO(thuongHieu);
//////
//////			KichThuocDTO kichThuocDTO = new KichThuocDTO();
//////			kichThuocDTO.setId(product.getKichThuoc().getId());
//////			kichThuocDTO.setName(product.getKichThuoc().getName());
//////			productDTO.setKichThuocDTO(kichThuocDTO);
//////
//////			GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
//////			gioiTinhDTO.setId(product.getGioiTinh().getId());
//////			gioiTinhDTO.setName(product.getGioiTinh().getName());
//////			productDTO.setGioiTinhDTO(gioiTinhDTO);
//////
//////			productDTOs.add(productDTO);
//////		}
//////		return productDTOs;
//////	}
////	
//////	@Override
//////	public List<ProductDTO> searchByCategory(String findName, String thuongHieuName, String kichThuocName,
//////			String gioiTinhName, Long priceStart, Long priceEnd, int categoryId, int start, int length) {
//////
//////		List<Product> listProducts = productDao.searchByCategory(findName, thuongHieuName, kichThuocName, gioiTinhName, priceStart, priceEnd, categoryId, start, length);
//////		
//////		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
//////		
//////		for (Product product : listProducts) {
//////			
//////			ProductDTO productDTO = new ProductDTO();
//////			productDTO.setId(product.getId());
//////			productDTO.setName(product.getName());
//////			productDTO.setPrice(product.getPrice());
//////			productDTO.setImage(product.getImage());
//////			productDTO.setDescription(product.getDescription());
//////			productDTO.setSoLuong(product.getSoLuong());
//////			
//////			CategoryDTO categoryDTO = new CategoryDTO();
//////			categoryDTO.setId(product.getCategory().getId());
//////			categoryDTO.setNameCategory(product.getCategory().getNameCategory());
//////			productDTO.setCategory(categoryDTO);
//////			
//////			ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
//////			thuongHieuDTO.setId(product.getThuongHieu().getId());
//////			thuongHieuDTO.setName(product.getThuongHieu().getName());
//////			productDTO.setThuongHieuDTO(thuongHieuDTO);
//////			
//////			KichThuocDTO kichThuocDTO = new KichThuocDTO();
//////			kichThuocDTO.setId(product.getKichThuoc().getId());
//////			kichThuocDTO.setName(product.getKichThuoc().getName());
//////			productDTO.setKichThuocDTO(kichThuocDTO);
//////			
//////			GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
//////			gioiTinhDTO.setId(product.getGioiTinh().getId());
//////			gioiTinhDTO.setName(product.getGioiTinh().getName());
//////			productDTO.setGioiTinhDTO(gioiTinhDTO);
//////			
//////			productDTOs.add(productDTO);
//////		}
//////		
//////		return productDTOs;
//////	}
////	
////	
////	@Override
////	public List<ProductDTO> search(String findName, String categoryName, String thuongHieuName, String kichThuocName,
////			String gioiTinh, Long priceStart, Long priceEnd, int start, int length) {
////
////		List<Product> listProducts = productDao.search(findName, categoryName, thuongHieuName, kichThuocName, gioiTinh,
////				priceStart, priceEnd, start, length);
////		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
////		for (Product product : listProducts) {
////			ProductDTO productDTO = new ProductDTO();
////			productDTO.setId(product.getId());
////			productDTO.setName(product.getName());
////			productDTO.setPrice(product.getPrice());
////			productDTO.setImage(product.getImage());
////			productDTO.setDescription(product.getDescription());
////			productDTO.setSoLuong(product.getSoLuong());
////
////			CategoryDTO categoryDTO = new CategoryDTO();
////			categoryDTO.setId(product.getCategory().getId());
////			categoryDTO.setNameCategory(product.getCategory().getNameCategory());
////			productDTO.setCategory(categoryDTO);
////
////			ThuongHieuDTO thuongHieu = new ThuongHieuDTO();
////			thuongHieu.setId(product.getThuongHieu().getId());
////			thuongHieu.setName(product.getThuongHieu().getName());
////			productDTO.setThuongHieuDTO(thuongHieu);
////
////			KichThuocDTO kichThuocDTO = new KichThuocDTO();
////			kichThuocDTO.setId(product.getKichThuoc().getId());
////			kichThuocDTO.setName(product.getKichThuoc().getName());
////			productDTO.setKichThuocDTO(kichThuocDTO);
////
////			GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
////			gioiTinhDTO.setId(product.getGioiTinh().getId());
////			gioiTinhDTO.setName(product.getGioiTinh().getName());
////			productDTO.setGioiTinhDTO(gioiTinhDTO);
////
////			productDTOs.add(productDTO);
////		}
////		return productDTOs;
////	}
////	
////	@Override
////	public ProductDTO get(int id) {
////		Product product = productDao.get(id);
////		ProductDTO dto = new ProductDTO();
////		dto.setId(product.getId());
////		dto.setName(product.getName());
////		dto.setDescription(product.getDescription());
////		dto.setImage(product.getImage());
////		dto.setPrice(product.getPrice());
////		dto.setSoLuong(product.getSoLuong());
////
////		CategoryDTO categoryDTO = new CategoryDTO();
////		categoryDTO.setId(product.getCategory().getId());
////		categoryDTO.setNameCategory(product.getCategory().getNameCategory());
////		dto.setCategory(categoryDTO);
////
////		ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
////		thuongHieuDTO.setId(product.getThuongHieu().getId());
////		thuongHieuDTO.setName(product.getThuongHieu().getName());
////		dto.setThuongHieuDTO(thuongHieuDTO);
////
////		KichThuocDTO kichThuocDTO = new KichThuocDTO();
////		kichThuocDTO.setId(product.getKichThuoc().getId());
////		kichThuocDTO.setName(product.getKichThuoc().getName());
////		dto.setKichThuocDTO(kichThuocDTO);
////
////		GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
////		gioiTinhDTO.setId(product.getGioiTinh().getId());
////		gioiTinhDTO.setName(product.getGioiTinh().getName());
////		dto.setGioiTinhDTO(gioiTinhDTO);
////
////		return dto;
////	}
////
////	
////	@Override
//////	public List<ProductDTO> searchByCategory(String findName, String thuongHieuName, String kichThuocName,
//////			String gioiTinhName, Long priceStart, Long priceEnd, int categoryId, int start, int length) {
////		
////	public List<ProductDTO> searchByCategory(String findName, String thuongHieuName, String kichThuocName,
////			String gioiTinhName, Long priceStart, Long priceEnd, int categoryId, int start, int length) {
////
////		List<Product> listProducts = productDao.searchByCategory(findName, thuongHieuName, kichThuocName, gioiTinhName,
////				priceStart, priceEnd, categoryId, start, length);
////		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
////		for (Product product : listProducts) {
////			ProductDTO ProductDTO = new ProductDTO();
////			ProductDTO.setId(product.getId());
////			ProductDTO.setName(product.getName());
////			ProductDTO.setPrice(product.getPrice());
////			ProductDTO.setImage(product.getImage());
////			ProductDTO.setDescription(product.getDescription());
////
////			CategoryDTO categoryDTO = new CategoryDTO();
////			categoryDTO.setId(product.getCategory().getId());
////			categoryDTO.setNameCategory(product.getCategory().getNameCategory());
////			ProductDTO.setCategory(categoryDTO);
////
////			ThuongHieuDTO thuongHieu = new ThuongHieuDTO();
////			thuongHieu.setId(product.getThuongHieu().getId());
////			thuongHieu.setName(product.getThuongHieu().getName());
////			ProductDTO.setThuongHieuDTO(thuongHieu);
////
////			KichThuocDTO kichThuocDTO = new KichThuocDTO();
////			kichThuocDTO.setId(product.getKichThuoc().getId());
////			kichThuocDTO.setName(product.getKichThuoc().getName());
////			ProductDTO.setKichThuocDTO(kichThuocDTO);
////
////			GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
////			gioiTinhDTO.setId(product.getGioiTinh().getId());
////			gioiTinhDTO.setName(product.getGioiTinh().getName());
////			ProductDTO.setGioiTinhDTO(gioiTinhDTO);
////
////			productDTOs.add(ProductDTO);
////		}
////		return productDTOs;
////	}
////	      
////	
////}
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.Product;
//import com.example.demo.dao.ProductDao;
//import com.example.demo.entity.Category;
//import com.example.demo.entity.GioiTinh;
//import com.example.demo.entity.KichThuoc;
//import com.example.demo.entity.ThuongHieu;
//import com.example.demo.model.CategoryDTO;
//import com.example.demo.model.GioiTinhDTO;
//import com.example.demo.model.KichThuocDTO;
//import com.example.demo.model.ProductDTO;
//import com.example.demo.model.ThuongHieuDTO;
//import com.example.demo.repository.ProductRepo;
//import com.example.demo.service.ProductService;
//
//@Transactional
//@Service
//public class ProductServiceImpl implements ProductService {
//	@Autowired
//	ProductDao productDao;
//	@Autowired
//	private ProductRepo productRepo;
//
//	@Override
//	public void insert(ProductDTO productDTO) {
//		Product product = new Product();
//		product.setName(productDTO.getName());
//		product.setPrice(productDTO.getPrice());
//		product.setDescription(productDTO.getDescription());
//		product.setImage(productDTO.getImage());
//		product.setSoLuong(productDTO.getSoLuong());
//
//		Category category = new Category();
//		category.setId(productDTO.getCategory().getId());
//		category.setNameCategory(productDTO.getCategory().getNameCategory());
//		product.setCategory(category);
//
//		ThuongHieu thuongHieu = new ThuongHieu();
//		thuongHieu.setId(productDTO.getThuongHieuDTO().getId());
//		thuongHieu.setName(productDTO.getThuongHieuDTO().getName());
//		product.setThuongHieu(thuongHieu);
//
//		KichThuoc kichThuoc = new KichThuoc();
//		kichThuoc.setId(productDTO.getKichThuocDTO().getId());
//		kichThuoc.setName(productDTO.getKichThuocDTO().getName());
//		product.setKichThuoc(kichThuoc);
//
//		GioiTinh gioiTinh = new GioiTinh();
//		gioiTinh.setId(productDTO.getGioiTinhDTO().getId());
//		gioiTinh.setName(productDTO.getGioiTinhDTO().getName());
//		product.setGioiTinh(gioiTinh);
//
//		productDao.insert(product);
//	}
//
//	@Override
//	public void update(ProductDTO productDTO) {
//		Product product = productDao.get(productDTO.getId());
//		if (product != null) {
//			product.setId(productDTO.getId());
//			product.setName(productDTO.getName());
//			product.setPrice(productDTO.getPrice());
//			product.setDescription(productDTO.getDescription());
//			product.setImage(productDTO.getImage());
//			product.setSoLuong(productDTO.getSoLuong());
//
//			Category category = new Category();
//			category.setId(productDTO.getCategory().getId());
//			category.setNameCategory(productDTO.getCategory().getNameCategory());
//			product.setCategory(category);
//
//			ThuongHieu thuongHieu = new ThuongHieu();
//			thuongHieu.setId(productDTO.getThuongHieuDTO().getId());
//			thuongHieu.setName(productDTO.getThuongHieuDTO().getName());
//			product.setThuongHieu(thuongHieu);
//
//			KichThuoc kichThuoc = new KichThuoc();
//			kichThuoc.setId(productDTO.getKichThuocDTO().getId());
//			kichThuoc.setName(productDTO.getKichThuocDTO().getName());
//			product.setKichThuoc(kichThuoc);
//
//			GioiTinh gioiTinh = new GioiTinh();
//			gioiTinh.setId(productDTO.getGioiTinhDTO().getId());
//			gioiTinh.setName(productDTO.getGioiTinhDTO().getName());
//			product.setGioiTinh(gioiTinh);
//
//			productDao.update(product);
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		Product product = productDao.get(id);
//		if (product != null) {
//			productDao.delete(product);
//		}
//	}
//
//	@Override
//	public List<ProductDTO> search(String findName, String categoryName, String thuongHieuName, String kichThuocName,
//			String gioiTinh, Long priceStart, Long priceEnd, int start, int length) {
//
//		List<Product> listProducts = productDao.search(findName, categoryName, thuongHieuName, kichThuocName, gioiTinh,
//				priceStart, priceEnd, start, length);
//		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
//		for (Product product : listProducts) {
//			ProductDTO productDTO = new ProductDTO();
//			productDTO.setId(product.getId());
//			productDTO.setName(product.getName());
//			productDTO.setPrice(product.getPrice());
//			productDTO.setImage(product.getImage());
//			productDTO.setDescription(product.getDescription());
//			productDTO.setSoLuong(product.getSoLuong());
//
//			CategoryDTO categoryDTO = new CategoryDTO();
//			categoryDTO.setId(product.getCategory().getId());
//			categoryDTO.setNameCategory(product.getCategory().getNameCategory());
//			productDTO.setCategory(categoryDTO);
//
//			ThuongHieuDTO thuongHieu = new ThuongHieuDTO();
//			thuongHieu.setId(product.getThuongHieu().getId());
//			thuongHieu.setName(product.getThuongHieu().getName());
//			productDTO.setThuongHieuDTO(thuongHieu);
//
//			KichThuocDTO kichThuocDTO = new KichThuocDTO();
//			kichThuocDTO.setId(product.getKichThuoc().getId());
//			kichThuocDTO.setName(product.getKichThuoc().getName());
//			productDTO.setKichThuocDTO(kichThuocDTO);
//
//			GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
//			gioiTinhDTO.setId(product.getGioiTinh().getId());
//			gioiTinhDTO.setName(product.getGioiTinh().getName());
//			productDTO.setGioiTinhDTO(gioiTinhDTO);
//
//			productDTOs.add(productDTO);
//		}
//		return productDTOs;
//	}
//
//	@Override
//	public ProductDTO get(int id) {
//		Product product = productDao.get(id);
//		ProductDTO dto = new ProductDTO();
//		dto.setId(product.getId());
//		dto.setName(product.getName());
//		dto.setDescription(product.getDescription());
//		dto.setImage(product.getImage());
//		dto.setPrice(product.getPrice());
//		dto.setSoLuong(product.getSoLuong());
//
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setId(product.getCategory().getId());
//		categoryDTO.setNameCategory(product.getCategory().getNameCategory());
//		dto.setCategory(categoryDTO);
//
//		ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
//		thuongHieuDTO.setId(product.getThuongHieu().getId());
//		thuongHieuDTO.setName(product.getThuongHieu().getName());
//		dto.setThuongHieuDTO(thuongHieuDTO);
//
//		KichThuocDTO kichThuocDTO = new KichThuocDTO();
//		kichThuocDTO.setId(product.getKichThuoc().getId());
//		kichThuocDTO.setName(product.getKichThuoc().getName());
//		dto.setKichThuocDTO(kichThuocDTO);
//
//		GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
//		gioiTinhDTO.setId(product.getGioiTinh().getId());
//		gioiTinhDTO.setName(product.getGioiTinh().getName());
//		dto.setGioiTinhDTO(gioiTinhDTO);
//
//		return dto;
//	}
//
//	@Override
//	public List<ProductDTO> searchByCategory(String findName, String thuongHieuName, String kichThuocName,
//			String gioiTinhName, Long priceStart, Long priceEnd, int categoryId, int start, int length) {
//
//		List<Product> listProducts = productDao.searchByCategory(findName, thuongHieuName, kichThuocName, gioiTinhName,
//				priceStart, priceEnd, categoryId, start, length);
//		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
//		for (Product product : listProducts) {
//			ProductDTO ProductDTO = new ProductDTO();
//			ProductDTO.setId(product.getId());
//			ProductDTO.setName(product.getName());
//			ProductDTO.setPrice(product.getPrice());
//			ProductDTO.setImage(product.getImage());
//			ProductDTO.setDescription(product.getDescription());
//
//			CategoryDTO categoryDTO = new CategoryDTO();
//			categoryDTO.setId(product.getCategory().getId());
//			categoryDTO.setNameCategory(product.getCategory().getNameCategory());
//			ProductDTO.setCategory(categoryDTO);
//
//			ThuongHieuDTO thuongHieu = new ThuongHieuDTO();
//			thuongHieu.setId(product.getThuongHieu().getId());
//			thuongHieu.setName(product.getThuongHieu().getName());
//			ProductDTO.setThuongHieuDTO(thuongHieu);
//
//			KichThuocDTO kichThuocDTO = new KichThuocDTO();
//			kichThuocDTO.setId(product.getKichThuoc().getId());
//			kichThuocDTO.setName(product.getKichThuoc().getName());
//			ProductDTO.setKichThuocDTO(kichThuocDTO);
//
//			GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
//			gioiTinhDTO.setId(product.getGioiTinh().getId());
//			gioiTinhDTO.setName(product.getGioiTinh().getName());
//			ProductDTO.setGioiTinhDTO(gioiTinhDTO);
//
//			productDTOs.add(ProductDTO);
//		}
//		return productDTOs;
//	}
//
////	public Product getProductById(int id) {
////		return productRepo.findById(id).get();
////	}
//
//
//}
