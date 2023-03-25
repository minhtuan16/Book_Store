//package com.example.demo.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dao.BillProductDao;
//import com.example.demo.entity.Bill;
//import com.example.demo.entity.BillProduct;
//import com.example.demo.entity.Product;
//import com.example.demo.model.BillProductDTO;
//import com.example.demo.model.ProductDTO;
//import com.example.demo.service.BillProductService;
//
//@Transactional
//@Service
//public class BillProductServiceImpl implements BillProductService {
//
//	@Autowired
//	private BillProductDao billProductDao;
//	
//	@Override
//	public void insert(BillProductDTO billProductDTO) {
//
//		BillProduct billProduct = new BillProduct();
//		billProduct.setUnitPrice(billProductDTO.getUnitPrice());
//		billProduct.setQuantity(billProductDTO.getQuantity());
//		
//		Bill bill = new Bill();
//		bill.setId(billProductDTO.getBillDTO().getId());
//		billProduct.setBill(bill);
//		
//		Product product = new Product();
//		product.setId(billProductDTO.getProductDTO().getId());
//		billProduct.setProduct(product);
//		
//		billProductDao.insert(billProduct);
//	}
//
//	@Override
//	public void update(BillProductDTO billProductDTO) {
//
//		BillProduct billProduct = billProductDao.get(billProductDTO.getId());
//		
//		if(billProduct != null) {
//			billProduct.setId(billProductDTO.getId());
//			billProduct.setUnitPrice(billProductDTO.getUnitPrice());
//			billProduct.setQuantity(billProductDTO.getQuantity());
//			
//			Bill bill = new Bill();
//			bill.setId(billProductDTO.getBillDTO().getId());
//			billProduct.setBill(bill);
//			
//			Product product = new Product();
//			product.setId(billProductDTO.getProductDTO().getId());
//			billProduct.setProduct(product);
//			
//			billProductDao.update(billProduct);
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		BillProduct billProduct = billProductDao.get(id);
//		if(billProduct != null) {
//			billProductDao.delete(billProduct);
//		}
//	}
//
//	@Override
//	public BillProductDTO get(int id) {
//		BillProduct billProduct = billProductDao.get(id);
//		return convertDTO(billProduct);
//	}
//
//	private BillProductDTO convertDTO(BillProduct billProduct) {
//		
//		BillProductDTO billProductDTO = new BillProductDTO();
//		
//		billProductDTO.setId(billProduct.getId());
//		billProductDTO.setUnitPrice(billProduct.getUnitPrice());
//		billProductDTO.setQuantity(billProduct.getQuantity());
//		
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setId(billProduct.getProduct().getId());
//		productDTO.setName(billProduct.getProduct().getName());
//		productDTO.setImage(billProduct.getProduct().getImage());
//		productDTO.setPrice(billProduct.getProduct().getPrice());
//		
//		billProductDTO.setProductDTO(productDTO);
//		
//		return billProductDTO;
//	}
//
//	@Override
//	public List<BillProductDTO> search(String findName, int start, int length) {
//
//		List<BillProduct> billProducts = billProductDao.search(findName, start, length);
//		
//		List<BillProductDTO> billProductDTOs = new ArrayList<BillProductDTO>();
//		
//		for(BillProduct billProduct : billProducts) {
//			billProductDTOs.add(convertDTO(billProduct));
//		}
//		return billProductDTOs;
//	}
//
//	@Override
//	public List<BillProductDTO> searchByBill(int billId, int start, int length) {
//		List<BillProduct> billProducts = billProductDao.searchByBill(billId, start, length);
//		
//		List<BillProductDTO> billProductDTOs = new ArrayList<BillProductDTO>();
//		
//		for (BillProduct billProduct : billProducts) {
//			billProductDTOs.add(convertDTO(billProduct));
//		}
//		
//		return billProductDTOs;
//	}
//}
