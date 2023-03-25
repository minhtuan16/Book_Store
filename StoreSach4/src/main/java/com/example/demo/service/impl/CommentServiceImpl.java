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
//import com.example.demo.dao.CommentDao;
//import com.example.demo.entity.Comment;
//import com.example.demo.entity.Product;
//import com.example.demo.entity2.User;
//import com.example.demo.model.CommentDTO;
//import com.example.demo.model.ProductDTO;
//import com.example.demo.model.UserDTO;
//import com.example.demo.service.CommentService;
//
//@Transactional
//@Service
//
//public class CommentServiceImpl implements CommentService{
//	
//	@Autowired
//	private CommentDao commentDao;
//
//	@Override
//	public void insert(CommentDTO commentDTO) {
//		Comment comment = new Comment();
//		comment.setComment(commentDTO.getComment());
//		comment.setCommentDate(new Date());
//		
//		Product product = new Product();
//		product.setId(commentDTO.getProductDTO().getId());
//		comment.setProduct(product);
//		
//		User user = new User();
//		user.setId(commentDTO.getUserDTO().getId());
//		comment.setUser(user);
//		
//		commentDao.insert(comment);
//	}
//
//	@Override
//	public void update(CommentDTO commentDTO) {
//		Comment comment = commentDao.get(commentDTO.getId());
//		
//		if(comment != null) {
//			comment.setComment(commentDTO.getComment());
//			
//			commentDao.update(comment);
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		Comment comment = commentDao.get(id);
//		
//		if(comment != null) {
//			commentDao.delete(id);
//		}
//	}
//
//	@Override
//	public CommentDTO get(int id) {
//		return null;
//	}
//
//	@Override
//	public List<CommentDTO> searchByProduct(int id) {
//
//		List<Comment> comments = commentDao.searchByProduct(id);
//		
//		List<CommentDTO> commentDTOs = new ArrayList<CommentDTO>();
//		
//		for(Comment comment : comments) {
//			CommentDTO commentDTO = new CommentDTO();
//			
//			commentDTO.setComment(comment.getComment());
//			commentDTO.setCommentDate(String.valueOf(comment.getCommentDate()));
//			
//			ProductDTO productDTO = new ProductDTO();
//			productDTO.setId(comment.getProduct().getId());
//			commentDTO.setProductDTO(productDTO);
//			
//			UserDTO userDTO = new UserDTO();
//			userDTO.setName(comment.getUser().getName());
//			commentDTO.setUserDTO(userDTO);
//			
//			commentDTOs.add(commentDTO);
//		}
//		return commentDTOs;
//	}
//
//	
//}
