//package com.example.demo.dao.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dao.CommentDao;
//import com.example.demo.entity.Comment;
//
//@Transactional
//@Repository
//
//public class CommentDaoImpl implements CommentDao {
//	
//	@PersistenceContext
//	EntityManager entityManager;
//
//	@Override
//	public void insert(Comment comment) {
//
//		entityManager.persist(comment);
//	}
//
//	@Override
//	public void update(Comment comment) {
//
//		entityManager.merge(comment);
//	}
//
//	@Override
//	public void delete(int id) {
//
//		entityManager.remove(get(id));
//	}
//
//	@Override
//	public Comment get(int id) {
//		
//		return entityManager.find(Comment.class, id);
//	}
//
//	@Override
//	public List<Comment> searchByProduct(int id) {
//
//		String jql = "SELECT c FROM Comment c JOIN c.product p JOIN c.user u WHERE p.id = :pId";
//		return entityManager.createQuery(jql, Comment.class).setParameter("pId", id).getResultList();
//	}
//
//	
//}
