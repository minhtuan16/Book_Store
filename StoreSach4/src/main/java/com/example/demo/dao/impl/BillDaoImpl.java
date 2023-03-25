//package com.example.demo.dao.impl;
//
////import java.util.List;
////
////import javax.persistence.EntityManager;
////import javax.persistence.PersistenceContext;
////
////import org.springframework.stereotype.Repository;
////import org.springframework.transaction.annotation.Transactional;
////
////import com.example.demo.dao.BillDao;
////import com.example.demo.entity.Bill;
////
////@Transactional
////@Repository
////public class BillDaoImpl implements BillDao{
////	
////	@PersistenceContext
////	EntityManager entityManager;
////
////	@Override
////	public void insert(Bill bill) {
////		entityManager.persist(bill);
////	}
////
////	@Override
////	public void update(Bill bill) {
////		entityManager.merge(bill);
////	}
////
////	@Override
////	public void delete(Bill bill) {
////		entityManager.remove(bill);
////	}
////
////	@Override
////	public Bill get(int id) {
////		return entityManager.find(Bill.class, id);
////	}
////
////	@Override
////	public List<Bill> search(String findName, int start, int length) {
////
////		String jql = "SELECT b FROM Bill b JOIN b.buyer u WHERE u.name LIKE :uname";
////		return entityManager.createQuery(jql, Bill.class).setParameter("uname", "%" + findName + "%").setFirstResult(start)
////				.setMaxResults(length).getResultList();
////	}
////
////	@Override
////	public List<Bill> searchByUserId(int buyerId, int start, int length) {
////		
////		String jql = "SELECT b FROM Bill b JOIN b.buyer u WHERE u.name = :buyerId";
////		return entityManager.createQuery(jql, Bill.class).setParameter("buyerId", buyerId).setFirstResult(start)
////				.setMaxResults(length).getResultList();
////	}
////
////}
//
//
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dao.BillDao;
//import com.example.demo.entity.Bill;
//
//@Transactional
//@Repository
//public class BillDaoImpl implements BillDao {
//	@PersistenceContext
//	EntityManager entityManager;
//
//	@Override
//	public void insert(Bill bill) {
//		entityManager.persist(bill);
//	}
//
//	@Override
//	public void update(Bill bill) {
//		entityManager.merge(bill);
//	}
//
//	@Override
//	public void delete(Bill bill) {
//		entityManager.remove(bill);
//
//	}
//
//	@Override
//	public Bill get(int id) {
//		return entityManager.find(Bill.class, id);
//	}
//
//	@Override
//	public List<Bill> search(String findName, int start, int length) {
//		String jql = "select b from Bill b join b.buyer u where u.name like :uname";
//		return entityManager.createQuery(jql, Bill.class).setParameter("uname","%"+findName+"%").setFirstResult(start).setMaxResults(length).getResultList();
//	}
//
//	@Override
//	public List<Bill> searchByUserId(int buyerId, int start, int length) {
//		String jql = "select b from Bill b join b.buyer u where u.id = :buyerId";
//		return entityManager.createQuery(jql, Bill.class).setParameter("buyerId", buyerId).setFirstResult(start).setMaxResults(length).getResultList();
//	}
//}
