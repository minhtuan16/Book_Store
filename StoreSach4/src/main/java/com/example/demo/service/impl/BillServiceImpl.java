//package com.example.demo.service.impl;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dao.BillDao;
//import com.example.demo.entity.Bill;
//import com.example.demo.entity2.User;
//import com.example.demo.model.BillDTO;
//import com.example.demo.model.UserDTO;
//import com.example.demo.service.BillService;
//import com.example.demo.utils.DateTimeUtils;
//
//@Transactional
//@Service
//
//public class BillServiceImpl implements BillService{
//	@Autowired
//	private BillDao billDao;
//
//	@Override
//	public void insert(BillDTO billDTO) {
////		Bill bill = new Bill();
////		
////		bill.setBuyDate(new Date());
////		bill.setPriceTotal(billDTO.getPriceTotal());
////		bill.setDiscountPercent(billDTO.getDiscountPercent());
////		bill.setStatus(billDTO.getStatus());
////		bill.setPay(billDTO.getPay());
////		bill.setBuyer(new User(billDTO.getUserDTO().getId()));
////		
////		billDao.insert(bill);
////		billDTO.setId(bill.getId());
//		
//		
//		Bill bill = new Bill();
//		
//		bill.setBuyDate(new Date());
//		bill.setBuyer(new User(billDTO.getUserDTO().getId()));
//		bill.setStatus(billDTO.getStatus());
//		bill.setPay(billDTO.getPay());
//
//		billDao.insert(bill);
//		billDTO.setId(bill.getId());
//	}
// 
//	@Override
//	public void update(BillDTO billDTO) {
//		Bill bill = billDao.get(billDTO.getId());
//		
//		if(bill != null) {
//			
//			// them dong 46
//			bill.setBuyDate(new Date());
//			
//			bill.setPriceTotal(billDTO.getPriceTotal());
//			bill.setDiscountPercent(billDTO.getDiscountPercent());
//			bill.setStatus(billDTO.getStatus());
//			bill.setPay(billDTO.getPay());
//			
//			//them dong 54
//			bill.setBuyer(new User(billDTO.getUserDTO().getId()));
//			
//			billDao.update(bill);
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		Bill bill = billDao.get(id);
//		
//		if(bill != null) {
//			billDao.delete(bill);
//		}
//	}
//
//	@Override
//	public BillDTO get(int id) {
//		Bill bill = billDao.get(id);
//		return convertDTO(bill);
//	}
//
//	private BillDTO convertDTO(Bill bill) {
//		BillDTO billDTO = new BillDTO();
//		
//		billDTO.setId(bill.getId());
//		billDTO.setBuyDate(DateTimeUtils.formatDate(bill.getBuyDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
//		billDTO.setPriceTotal(bill.getPriceTotal());
//		billDTO.setDiscountPercent(bill.getDiscountPercent());
//		// them dong 79
//		billDTO.setStatus(bill.getStatus());
//		
//		billDTO.setPay(bill.getPay());
//		
//		UserDTO userDTO = new UserDTO();
//		userDTO.setId(bill.getBuyer().getId());
//		userDTO.setAddress(bill.getBuyer().getAddress());
//		userDTO.setName(bill.getBuyer().getAddress());
//		userDTO.setPhone(bill.getBuyer().getPhone());
//		
//		billDTO.setUserDTO(userDTO);
//		return billDTO;
//	}
//
//	@Override
//	public List<BillDTO> search(String findName, int start, int length) {
//
//		List<Bill> bills = billDao.search(findName, start, length);
//		
//		List<BillDTO> billDTOs = new ArrayList<BillDTO>();
//		
//		for(Bill bill : bills) {
//			billDTOs.add(convertDTO(bill));
//		}
//		return billDTOs;
//	}
//
//	@Override
//	public List<BillDTO> searchByUserId(int buyerId, int start, int length) {
//
//		List<Bill> bills = billDao.searchByUserId(buyerId, start, length);
//		
//		List<BillDTO> billDTOs = new ArrayList<BillDTO>();
//		
//		if(bills.isEmpty()) {
//			return null;
//		} else {
//			for(Bill bill : bills) {
//				billDTOs.add(convertDTO(bill));
//			}
//		}
//		return billDTOs;
//	}
//
//}
