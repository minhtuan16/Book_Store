//package com.example.demo.controller;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.model.BillDTO;
//import com.example.demo.model.BillProductDTO;
//import com.example.demo.model.CommentDTO;
//import com.example.demo.model.ProductDTO;
//import com.example.demo.model.ReviewDTO;
//import com.example.demo.model.UserDTO;
//import com.example.demo.model.UserPrincipal;
//import com.example.demo.service.BillProductService;
//import com.example.demo.service.BillService;
//import com.example.demo.service.CommentService;
//import com.example.demo.service.ProductService;
//import com.example.demo.service.ReviewService;
//import com.example.demo.service.UserService;
//
//@Controller
//
//public class MemberController {
//
//	@Autowired
//	private CommentService commentService;
//
//	@Autowired
//	private ProductService productService;
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private BillProductService billProductService;
//
//	@Autowired
//	private BillService billService;
//
//	@Autowired
//	private ReviewService reviewService;
//
//	@PostMapping(value = "/member/comment")
//	public String comment(HttpServletRequest request, @RequestParam(name = "productId") Integer productId,
//			@RequestParam(name = "comment") String comment) {
//		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		Integer userId = principal.getId();
//
//		UserDTO userDTO = new UserDTO();
//		userDTO.setName(principal.getName());
//		userDTO.setId(principal.getId());
//
//		CommentDTO commentDTO = new CommentDTO();
//		commentDTO.setUserDTO(userDTO);
//
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setId(productId);
//		commentDTO.setProductDTO(productDTO);
//		commentDTO.setComment(comment);
//		commentService.insert(commentDTO);
//
//		return "redirect:/product?id=" + commentDTO.getProductDTO().getId();
//	}
//
//	@PostMapping(value = "/member/review")
//	public String review(HttpServletRequest request, @ModelAttribute ReviewDTO reviewDTO,
//			@RequestParam(name = "productId") Integer productId, @RequestParam(name = "starNumber") int starNumber) {
//		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		// Long userId = principal.getId();
//		int check = 0;
//		List<ReviewDTO> list = reviewService.find(productId);
//		if (list.isEmpty()) {
//			UserDTO userDTO = new UserDTO();
//			userDTO.setName(principal.getName());
//			userDTO.setId(principal.getId());
//			reviewDTO.setUserDTO(userDTO);
//
//			ProductDTO productDTO = new ProductDTO();
//			productDTO.setId(productId);
//			reviewDTO.setProductDTO(productDTO);
//			reviewDTO.setStarNumber(starNumber);
//			reviewService.add(reviewDTO);
//		}
//		for (ReviewDTO reviewDTO2 : list) {// kiem tra de moi nguoi dung chi comment dc 1 laan
//			if (reviewDTO2.getUserDTO().getId() == principal.getId()) {
//				check = 1;
//				break;
//
//			} else {
//				check = 2;
//			}
//		}
//		if (check == 2) {
//			UserDTO userDTO = new UserDTO();
//			userDTO.setName(principal.getName());
//			userDTO.setId(principal.getId());
//			reviewDTO.setUserDTO(userDTO);
//			ProductDTO productDTO = new ProductDTO();
//			productDTO.setId(productId);
//			reviewDTO.setProductDTO(productDTO);
//			reviewDTO.setStarNumber(starNumber);
//			reviewService.add(reviewDTO);
//		}
//
//		return "redirect:/product?id=" + productId;
//	}
//
//	@GetMapping(value = "/member/bill/add")
//	public String addOrder(HttpSession session, @RequestParam(value = "page", required = false) Integer page,
//			Model model) throws IOException {
//		// lay member dang nhap hien tai
//		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		UserDTO user = new UserDTO();
//		user.setId(principal.getId());
//
//		// lay sp trong gio hang
//		Object object = session.getAttribute("cart");
//
//		if (object != null) {
//			Map<String, BillProductDTO> map = (Map<String, BillProductDTO>) object;
//
//			BillDTO bill = new BillDTO();
//			bill.setUserDTO(user);
//			bill.setStatus("NEW");
//			billService.insert(bill);
//
//			long totalPrice = 0L;
//			for (Entry<String, BillProductDTO> entry : map.entrySet()) {
//				BillProductDTO billProduct = entry.getValue();
//				billProduct.setBillDTO(bill);
//
//				billProductService.insert(billProduct);
//
//				totalPrice = totalPrice + (billProduct.getQuantity() * billProduct.getUnitPrice());
//																									// bill
//				//update so luong sp sau khi mua hang thanh cong.
//				
//				ProductDTO productDTO=productService.get(entry.getValue().getProductDTO().getId());
//				productDTO.setSoLuong(productDTO.getSoLuong()-billProduct.getQuantity());
//				productService.update(productDTO);
//			}
//			
//			long finalTotalPrice = 0L;
//			/// discount
//			page = page == null ? 1 : page;
//			List<BillDTO> list = billService.searchByUserId(principal.getId(), 0, page * 10); // search trong bang
//
//			// lan dau mua
//			if (list.size() == 1) { // lan dau mua
//				 finalTotalPrice = totalPrice - ((totalPrice * 5 )/ 100) + 30000; 
//				bill.setPriceTotal(finalTotalPrice);
//				bill.setDiscountPercent(5);
//				bill.setPay(String.valueOf(totalPrice));
//				System.out.println("khuyen mai 5% cho lan thanh toan dau tien cua ban!!!!" + bill.getPriceTotal());
//				
//			} else {
//				bill.setPriceTotal(totalPrice);
//				bill.setDiscountPercent(0);
//				bill.setPay(String.valueOf(totalPrice));
//			}
//			billService.update(bill);// udpate lai gia
//			
//			// goi sms service
//			// SMSDTO smsdto = new SMSDTO();
//			// smsdto.setCustomerPhone(String.valueOf((principal.getPhone())));
//			// smsdto.setContent("Bạn vừa thanh toán thành công đơn hàng trên hệ thống trung
//			// tâm java!!!");
//
//			// smsService.sendSMS(smsdto);
//
//			String content = "";
//
//			for (BillProductDTO i : map.values()) {
//				System.out.println(
//						"sản phẩm: " + i.getProductDTO().getName() + " Số tiền: " + i.getUnitPrice() * i.getQuantity());
//				content += "Sản phẩm: " + i.getProductDTO().getName() + ", Số tiền: " + i.getUnitPrice() * i.getQuantity()
//						+ " (đ); \n";
//			}
//
//			
//			// xóa cart khi đã thanh toán
//			session.removeAttribute("cart");
//
//			return "redirect:/member/bills";
//		}
//		return "redirect:/products";
//	} 
//	
//
//	@GetMapping(value = "/member/bills")
//	public String bills(HttpServletRequest request, @RequestParam(value = "keyword", required = false) Integer keyword,
//			@RequestParam(value = "page", required = false) Integer page) {
//		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////		UserDTO userDTO = new UserDTO();
////		userDTO.setId(principal.getId());
//		
//		page = page == null ? 1 : page;
//		keyword = principal.getId();
//		List<BillDTO> listBill = billService.searchByUserId(keyword, 0, page * 10); // search trong bang bill
//		request.setAttribute("bills", listBill);// danh sach bill cua 1 client
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
// 
//		return "member/bills";
// 
//	}
//
//	long billId;
//
//	@GetMapping(value = "/member/bill")
//	public String billDetail(HttpServletRequest request, @RequestParam(name = "billId", required = true) Integer billId,
//			@RequestParam(value = "keyword", required = false) Integer keyword,
//			@RequestParam(value = "page", required = false) Integer page) {
//
//		this.billId = billId;
//		page = page == null ? 1 : page;
//		keyword = billId;
//		List<BillProductDTO> listBillProduct = billProductService.searchByBill(keyword, 0, page * 10);// danh sach san
//																										// pham trong 1
//		// bill
//		request.setAttribute("billProducts", listBillProduct);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		return "member/bill";
//	}
//
//	// xoa item in list bill
//	@GetMapping(value = "/member/delete/bills")
//	public String deleteBillsProduct(@RequestParam(name = "billId", required = true) Integer billId) {
//		billService.delete(billId);
//		return "redirect:/member/bills";
//	}
//
//	// xoa item in list bill detail
//	@GetMapping(value = "/member/delete/bill")
//	public String deleteBillProduct(@RequestParam(name = "billId", required = true) Integer billId) {
//		System.out.println(billId);
//		System.out.println();
//		billProductService.delete(billId);
//		return "redirect:/member/bill?billId=" + this.billId;
//	}
//}
