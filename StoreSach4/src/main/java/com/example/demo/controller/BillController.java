////package com.example.demo.controller;
////
////import java.text.ParseException;
////import java.text.SimpleDateFormat;
////import java.util.ArrayList;
////import java.util.Arrays;
////import java.util.Date;
////import java.util.List;
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
////import org.springframework.web.bind.annotation.ModelAttribute;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////
////import com.example.demo.entity.Bill;
////import com.example.demo.entity.User;
////import com.example.demo.repository.BillRepo;
////import com.example.demo.repository.CouponRepo;
////import com.example.demo.repository.UserRepo;
////import com.example.demo.utils.BillStatCouponCode;
////import com.example.demo.utils.BillStatMonth;
////import com.example.demo.utils.BillStatUsername;
////import com.example.demo.utils.MailService;
////
////@Controller
////@RequestMapping("/admin/bill")
////public class BillController {
////	private static Logger logger = LoggerFactory.getLogger(BillController.class);
////
////	@Autowired
////	BillRepo billRepo;
////
////	@Autowired
////	UserRepo userRepo;
////	
////	@Autowired
////	MailService mailService;
////	
////	@Autowired
////	CouponRepo couponRepo;
////
////	@GetMapping("/create")
////	public String create(Model model) {
////		List<User> users = userRepo.findAll();
////		model.addAttribute("users", users);
////
////		return "admin/bill/create";
////	}
////
////	@PostMapping("/create")
////	public String create(@ModelAttribute Bill bill,
////			@RequestParam("coupon_Code") String couponCode,
////			@RequestParam("buy_Date") String buy_Date) {
////		bill.setBuyDate(new Date());
////		
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////		
////		try {
////			bill.setBuyDate(sdf.parse(buy_Date));
////		} catch (ParseException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////
////		long expiredDay = couponRepo.findByCouponCode(couponCode).getExpiredDate().getTime();
////		
////		if(expiredDay >= bill.getBuyDate().getTime()) {
////			bill.setDiscount(couponRepo.findByCouponCode(couponCode).getDiscountAmount());
////			bill.setCouponCode(couponRepo.findByCouponCode(couponCode).getCouponCode());
////		} 
////		
////		double payment = ((bill.getTotalPrice()) - (((bill.getTotalPrice())*(bill.getDiscount()))/100));
////		
////		bill.setTotalPayment(payment);
////		
////		billRepo.save(bill);
////		
//////		User user = userRepo.getById(bill.getUser().getId());
//////		
//////		mailService.sendEmail(user.getMailUser(), "SHOP_STORE", "Chuc mung ban da co don hang thanh cong !");
////		
////		return "redirect:/admin/bill/search";
////	}
////
////	@GetMapping("/update")
////	public String update(@RequestParam("id") int id, Model model) {
////		List<User> users = userRepo.findAll();
////		model.addAttribute("users", users);
////
////		Bill bill = billRepo.getById(id);
////
////		model.addAttribute("bill", bill);
////		return "admin/bill/update";
////	}
////
////	@PostMapping("/update")
////	public String update(@ModelAttribute Bill bill) {
////		bill.setBuyDate(new Date());
////		billRepo.save(bill);
////		return "redirect:/admin/bill/search";
////	}
////
////	@GetMapping("/delete")
////	public String delete(@RequestParam("id") int id) {
////		billRepo.deleteById(id);
////		return "redirect:/admin/bill/search";
////	}
////
////	@GetMapping("/search")
////	public String search(Model model, 
////			@RequestParam(name = "id", required = false) Integer id,
////			@RequestParam(name = "fromDate", required = false) String fromDate,
////			@RequestParam(name = "toDate", required = false) String toDate,
////			@RequestParam(name = "userID", required = false) Integer userID,
////			@RequestParam(name = "page", required = false) Integer page,
////			@RequestParam(name = "size", required = false) Integer size) throws ParseException {
////
////		List<User> users = userRepo.findAll();
////		model.addAttribute("users", users);
////
////		if (size == null) {
////			size = 5;
////		}
////		if (page == null) {
////			page = 0;
////		}
////		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
////
////		if (userID != null ) {
////			Page<Bill> pageBill = billRepo.search_uID(userID, pageable);
////			model.addAttribute("list", pageBill.toList());
////			model.addAttribute("totalPage", pageBill.getTotalPages());
////		} else if (userID == null && fromDate != null && !fromDate.trim().isEmpty() && toDate == null) {
////			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////
////			Page<Bill> pageBill = billRepo.searchFrom(sdf.parse(fromDate), pageable);
////			model.addAttribute("list", pageBill.toList());
////			model.addAttribute("totalPage", pageBill.getTotalPages());
////		} else if (userID == null && fromDate == null && toDate != null && !toDate.trim().isEmpty()) {
////			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////
////			Page<Bill> pageBill = billRepo.searchTo(sdf.parse(toDate), pageable);
////			model.addAttribute("list", pageBill.toList());
////			model.addAttribute("totalPage", pageBill.getTotalPages());
////		} else if (userID == null && fromDate != null && !fromDate.trim().isEmpty() && toDate != null
////				&& !toDate.trim().isEmpty()) {
////			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////
////			Page<Bill> pageBill = billRepo.searchFromTo(sdf.parse(fromDate), sdf.parse(toDate), pageable);
////			model.addAttribute("list", pageBill.toList());
////			model.addAttribute("totalPage", pageBill.getTotalPages());
////		} else if(id != null) {
////			Bill bill = billRepo.findById(id).orElse(null);
////			if(bill != null) {
////				model.addAttribute("list", Arrays.asList(bill));
////			} else {
////				logger.info("id not found !");
////			}
////			model.addAttribute("totalPage", 0);
////		} else 
////			{
////			Page<Bill> pageBill = billRepo.findAll(pageable);
////			model.addAttribute("list", pageBill.toList());
////			model.addAttribute("totalPage", pageBill.getTotalPages());
////		}
////
////		model.addAttribute("page", page);
////		model.addAttribute("size", size);
////		model.addAttribute("id", id == null ? "" : id);
////		model.addAttribute("fromDate", fromDate == null ? "" : fromDate);
////		model.addAttribute("toDate", toDate == null ? "" : toDate);
////		model.addAttribute("userID", userID == null ? "" : userID);
////		return "admin/bill/search";
////	}
////	
////	@GetMapping("/thongKe")
////	public String thongKe(Model model) {
////		List<Object[]> list = billRepo.thongKeTheoThang();
////		
////		List<BillStatMonth> billStatMonths = new ArrayList<BillStatMonth>();
////		
////		if(list != null && !list.isEmpty()) {
////			for(Object[] obj : list) {
////				BillStatMonth billStatMonth = new BillStatMonth();
////				billStatMonth.setSoLuong(Integer.parseInt((obj[0]).toString()));
////				billStatMonth.setThang(Integer.parseInt((obj[1]).toString()));
////				
////				billStatMonths.add(billStatMonth);
////			}
////		}
////		
////		model.addAttribute("billStatMonths", billStatMonths);
////		return "admin/bill/thongKe";
////	}
////	
////	@GetMapping("/thongKe2")
////	public String thongKe2(Model model) {
////		List<Object[]> list = billRepo.thongKeTheoUsername();
////		
////		List<BillStatUsername> billStatUsernames = new ArrayList<BillStatUsername>();
////		
////		if(list != null && !list.isEmpty()) {
////			for(Object[] obj : list) {
////				BillStatUsername billStatUsername = new BillStatUsername();
////				billStatUsername.setSoLuong(Integer.parseInt((obj[0]).toString()));
////				billStatUsername.setName(obj[1].toString());
////				
////				billStatUsernames.add(billStatUsername);	
////			}
////		}
////		model.addAttribute("billStatUsernames", billStatUsernames);
////		return "admin/bill/thongKe2";
////	}
////	
////	@GetMapping("/thongKe3")
////	public String thongKe3(Model model) {
////		List<Object[]> list = billRepo.thongKeTheoCouponCode();
////		
////		List<BillStatCouponCode> billStatCouponCodes = new ArrayList<BillStatCouponCode>();
////		
////		if(list != null && !list.isEmpty()) {
////			for(Object[] obj : list) {
////				BillStatCouponCode billStatCouponCode = new BillStatCouponCode();
////				billStatCouponCode.setSoLuong(Integer.parseInt((obj[0]).toString()));
////				billStatCouponCode.setCouponCode(obj[1].toString());
////				
////				billStatCouponCodes.add(billStatCouponCode);	
////			}
////		}
////		model.addAttribute("billStatCouponCodes", billStatCouponCodes);
////		return "admin/bill/thongKe3";
////	}
////}
//
//
//package com.example.demo.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.model.BillDTO;
//import com.example.demo.model.BillProductDTO;
//import com.example.demo.service.BillProductService;
//import com.example.demo.service.BillService;
//
//@Controller
//
//public class BillController {
//
//	@Autowired
//	private BillService billService;
//	
//	@Autowired
//	private BillProductService billProductService;
//	
//	@GetMapping(value = "/admin/bill/search")
//	public String search(HttpServletRequest request,
//			@RequestParam(name = "keyword", required = false) String keyword,
//			@RequestParam(name = "page", required = false) Integer page) {
//		
//		page = page == null ? 1 : page;
//		keyword = keyword == null ? "" : keyword;
//		
//		List<BillDTO> list = billService.search(keyword, 0, page * 20);
//		request.setAttribute("keyword", keyword);
//		request.setAttribute("page", page);
//		request.setAttribute("bills", list);
//		
//		return "/admin/bill/bill";
//	}
//	
//	@GetMapping(value = "/admin/bill-product/search")
//	public String searchBillProduct(HttpServletRequest request,
//			@RequestParam(name = "idBill", required = false) Integer idBill,
//			@RequestParam(name = "keyword", required = false) Integer keyword,
//			@RequestParam(name = "page", required = false) Integer page) {
//		page = page == null ? 1 : page;
//		keyword = idBill;
//		
//		List<BillProductDTO> listBillProductDTOs = billProductService.searchByBill(idBill, 0, page * 20);
//		request.setAttribute("billProducts", listBillProductDTOs);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		
//		return "/admin/bill/bill-product";
//	}
//	
//	@GetMapping(value = "/admin/delete/bills")
//	public String deleteBill(@RequestParam(name = "idBill", required = true) Integer billId) {
//		billService.delete(billId);
//		
//		return "redirect:/admin/bill/search";
//	}
//	
//	// xóa item in list bill detail
//	@GetMapping(value = "/admin/delete/bill-product")
//	public String deleteBillProduct(@RequestParam(name = "idBill", required = true) Integer billId) {
//		System.out.println(billId);
//		System.out.println("-----");
//		billProductService.delete(billId);
//		 
//		return "redirect:/admin/bill-product/search?idBill=" + billId;
//	}
//}
