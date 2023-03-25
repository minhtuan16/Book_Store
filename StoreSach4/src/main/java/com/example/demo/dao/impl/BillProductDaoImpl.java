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
//import com.example.demo.dao.BillProductDao;
//import com.example.demo.entity.BillProduct;
//
//@Transactional
//@Repository
//
//public class BillProductDaoImpl implements BillProductDao{
//
//	@PersistenceContext
//	EntityManager entityManager;
//	
//	@Override
//	public void insert(BillProduct billProduct) {
//		entityManager.persist(billProduct);
//	}
//
//	@Override
//	public void update(BillProduct billProduct) {
//		entityManager.merge(billProduct);
//	}
//
//	@Override
//	public void delete(BillProduct billProduct) {
//		entityManager.remove(billProduct);
//	}
//
//	@Override
//	public BillProduct get(int id) {
//		return entityManager.find(BillProduct.class, id);
//	}
//
//	@Override
//	public List<BillProduct> search(String findName, int start, int length) {
//
//		String jql = "SELECT bp FROM BillProduct bp JOIN bp.product p JOIN bp.bill b WHERE p.name LIKE :pname";
//				
//		return entityManager.createQuery(jql, BillProduct.class).setParameter("pname", "%" + findName + "%").setFirstResult(start)
//				.setMaxResults(length).getResultList();
//	}
//
//	@Override
//	public List<BillProduct> searchByBill(int idBill, int start, int length) {
//
//		String jql = "SELECT bp FROM BillProduct bp JOIN bp.product p JOIN bp.bill b WHERE b.id = :billId";
//		return entityManager.createQuery(jql, BillProduct.class).setParameter("billId", idBill).setFirstResult(start)
//				.setMaxResults(length).getResultList();
//	}
//
//	
//}
