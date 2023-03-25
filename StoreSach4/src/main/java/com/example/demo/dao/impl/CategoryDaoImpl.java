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
//import com.example.demo.dao.CategoryDao;
//import com.example.demo.entity.Category;
//
//@Transactional
//@Repository
//
//public class CategoryDaoImpl implements CategoryDao {
//	
//	@PersistenceContext
//	EntityManager entityManager;
//
//	@Override
//	public void insert(Category category) {
//		// TODO Auto-generated method stub
//		entityManager.persist(category);
//	}
//
//	@Override
//	public void update(Category category) {
//		// TODO Auto-generated method stub
//		entityManager.merge(category);
//	}
//
//	@Override
//	public void delete(Category category) {
//		// TODO Auto-generated method stub
//		entityManager.remove(category);
//	}
//
//	@Override
//	public Category get(int id) {
//		// TODO Auto-generated method stub
//		return entityManager.find(Category.class, id);
//	}
//
//	@Override
//	public List<Category> search(String findNameCategory) {
//		// TODO Auto-generated method stub
//		String jql = "select c from Category c where c.nameCategory like : nameCategory";
//		return entityManager.createQuery(jql, Category.class).setParameter("nameCategory", "%" + findNameCategory + "%").getResultList();
//	}
//
//	@Override
//	public List<Category> search(String findNameCategory, int start, int length) {
//		// TODO Auto-generated method stub
//		String jql = "select c from Category c where c.nameCategory like : nameCategory";
//		return entityManager.createQuery(jql, Category.class).setParameter("nameCategory", "%" + findNameCategory + "%").setFirstResult(start).setMaxResults(length).getResultList();
//	}
//
//	@Override
//	public int count(String findNameCategory) {
//		// TODO Auto-generated method stub
//		String jql = "select count(c) from Category c where c.nameCategory like : nameCategory";
//
//		return entityManager.createQuery(jql, Integer.class).setParameter("nameCategory", "%" + findNameCategory + "%").getSingleResult();
//	}
//
//}
