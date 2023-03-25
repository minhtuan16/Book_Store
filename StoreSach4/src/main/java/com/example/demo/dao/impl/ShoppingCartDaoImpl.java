//package com.example.demo.dao.impl;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dao.ShoppingCartDao;
//import com.example.demo.entity.GioiTinh;
//import com.example.demo.entity.ShoppingCart;
//
//@Transactional
//@Repository
//
//public class ShoppingCartDaoImpl implements ShoppingCartDao {
//	@PersistenceContext
//	EntityManager entityManager;
//
//	@Override
//	public void insert(ShoppingCart shoppingCart) {
//		entityManager.persist(shoppingCart);
//	}
//
//	@Override
//	public void update(ShoppingCart shoppingCart) {
//		entityManager.merge(shoppingCart);
//	}
//
//	@Override
//	public void delete(int id) {
//		entityManager.remove(getById(id));
//	}
//
//	@Override
//	public ShoppingCart getById(int id) {
//		// TODO Auto-generated method stub
//		return entityManager.find(ShoppingCart.class, id);
//	}
//
//}
