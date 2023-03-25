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
//import com.example.demo.dao.ReviewDao;
//import com.example.demo.entity.Product;
//import com.example.demo.entity.Review;
//import com.example.demo.entity2.User;
//import com.example.demo.model.ProductDTO;
//import com.example.demo.model.ReviewDTO;
//import com.example.demo.model.SearchReviewDTO;
//import com.example.demo.model.UserDTO;
//import com.example.demo.service.ReviewService;
//import com.example.demo.utils.DateTimeUtils;
//
//@Transactional
//@Service
//
//public class ReviewServiceImpl implements ReviewService {
//	
//	@Autowired
//	private ReviewDao reviewDao;
//
//	@Override
//	public void add(ReviewDTO reviewDTO) {
//		Review review = new Review();
//		review.setReviewDate(new Date());
//		review.setStarNumber(reviewDTO.getStarNumber());
//		review.setProduct(new Product(reviewDTO.getProductDTO().getId()));
//		
//		User user= new User();
//		user.setName(reviewDTO.getUserDTO().getName());
//		user.setId(reviewDTO.getUserDTO().getId());
//		
//		review.setUser(user);
//		reviewDao.add(review);
//	}
//
//	@Override
//	public void delete(int id) {
//		Review review = reviewDao.getById(id);
//		if (review != null) {
//			reviewDao.delete(review);
//		}
//	}
//
//	@Override
//	public void edit(ReviewDTO reviewDTO) {
//		Review review = reviewDao.getById(reviewDTO.getId());
//		if (review != null) {
//			review.setStarNumber(reviewDTO.getStarNumber());
//			review.setProduct(new Product(reviewDTO.getProductDTO().getId()));
//			User user= new User();
//			user.setName(reviewDTO.getUserDTO().getName());
//			review.setUser(user);
//		}
//		reviewDao.edit(review);
//	}
//
//	@Override
//	public ReviewDTO getById(int id) {
//		Review review = reviewDao.getById(id);
//		if (review != null) {
//			convert(review);
//		}
//		return null;
//	}
//
//	private ReviewDTO convert(Review review) {
//		ReviewDTO reviewDTO = new ReviewDTO();
//		reviewDTO.setId(review.getId());
//		reviewDTO.setReviewDate(DateTimeUtils.formatDate(review.getReviewDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
//		reviewDTO.setStarNumber(review.getStarNumber());
//		
//		ProductDTO productDTO= new ProductDTO();
//		productDTO.setId(review.getProduct().getId());
//		reviewDTO.setProductDTO(productDTO);
//		
//		UserDTO userDTO= new UserDTO();
//		userDTO.setName(review.getUser().getName());
//		reviewDTO.setUserDTO(userDTO);
//		
//		return reviewDTO;
//	}
//
//	@Override
//	public List<ReviewDTO> find(int productId) {
//		List<Review> reviews = reviewDao.find(productId);
//		List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
//		reviews.forEach(rev -> {
//			reviewDTOs.add(convert(rev));
//		});
//		return reviewDTOs;
//	}
//
//	@Override
//	public Long count(SearchReviewDTO searchReviewDTO) {
//		return reviewDao.count(searchReviewDTO);
//	}
//
//	@Override
//	public Long coutTotal(SearchReviewDTO searchReviewDTO) {
//		return reviewDao.countTotal(searchReviewDTO);
//	}
//
//}
