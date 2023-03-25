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
//import com.example.demo.dao.ProductDao;
//import com.example.demo.entity.Product;
//
//@Transactional
//@Repository
//
//public class ProductDaoImpl implements ProductDao {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public void insert(Product product) {
//		entityManager.persist(product);
//	}
//
//	@Override
//	public void update(Product product) {
//		entityManager.merge(product);
//	}
//
//	@Override
//	public void delete(Product product) {
//		entityManager.remove(product);
//	}
//	
////	@Override
////	public Product get(int id) {
////		return entityManager.find(Product.class, id);
////	}
//
//	@Override
//	public Product get(int id) {
//		String jql = "SELECT p FROM Product p JOIN p.category c" 
//				+ " JOIN p.thuongHieu th" 
//				+ " JOIN p.kichThuoc kt"
//				+ " JOIN p.gioiTinh gt" 
//				+ " WHERE p.id = :pId";
//		
//		return entityManager.createQuery(jql, Product.class).setParameter("pId", id).getSingleResult();
//	}
//
////	@Override
////	public List<Product> search(String findName, String categoryName, String thuongHieuName, String kichThuocName,
////			String gioiTinhName, Long priceStart, Long priceEnd, int start, int length) {
////		try {
////			String jql = "SELECT p FROM Product p JOIN p.category c" 
////					+ " JOIN p.thuongHieu th" 
////					+ " JOIN p.kichThuoc kt"
////					+ " JOIN p.gioiTinh gt" 
////					+ "WHERE (p.name LIKE :pname and c.nameCategory LIKE :cname and th.name LIKE :thname and kt.name LIKE :ktname and gt.name LIKE :gtname"
////					+ " and (p.price BETWEEN :priceStart AND :priceEnd))";
////			
////			return entityManager.createQuery(jql, Product.class).setParameter("pname", "%" + findName + "%")
////					.setParameter("cname", "%" + categoryName + "%")
////					.setParameter("thname", "%" + thuongHieuName + "%")
////					.setParameter("ktname", "%" + kichThuocName + "%")
////					.setParameter("gtname", "%" + gioiTinhName + "%")
////					.setParameter("priceStart", priceStart).setParameter("priceEnd", priceEnd)
////					.setFirstResult(start).setMaxResults(length).getResultList();
////		} catch (Exception e) {
////			System.out.println("Loi " + e);
////		}
////		return null;
////	}
//	
//	@Override
//	public List<Product> search(String findName, String categoryName, String thuongHieuName, String KichThuocName,
//			String gioiTinhName, Long priceStart, Long priceEnd, int start, int length) {
// 
//		try {
//			String hql = "SELECT p FROM Product p join p.category c"
//					+ " join p.thuongHieu th"
//					+ " join p.kichThuoc kt"
//					+ " join p.gioiTinh gt"
//					+ " where (p.name like :pname and c.nameCategory like :cname and th.name like :thname and kt.name like :ktname and gt.name like :gtname"
//					+ " and (p.price between :priceStart AND :priceEnd ))";
//
//			return entityManager.createQuery(hql, Product.class).setParameter("pname", "%" + findName + "%")
//					.setParameter("cname", "%" + categoryName + "%").setParameter("thname", "%" + thuongHieuName + "%")
//					.setParameter("ktname", "%" + KichThuocName + "%").setParameter("gtname", "%" + gioiTinhName + "%")
//					.setParameter("priceStart", priceStart).setParameter("priceEnd", priceEnd).setFirstResult(start)
//					.setMaxResults(length).getResultList();
//
//		} catch (Exception e) {
//			System.out.println("loi" + e);
//		}
//		return null;
//
//	}
//	
//	
//
//	@Override
//	public List<Product> searchByCategory(String findName, String thuongHieuName, String kichThuocName,
//			String gioiTinhName, Long priceStart, Long priceEnd, int categoryId, int start, int length) {
//		
//		String jql = "SELECT p FROM Product p INNER JOIN Category c ON c.id = p.category.id" 
//				+ " INNER JOIN ThuongHieu th ON p.thuongHieu.id = th.id" 
//				+ " INNER JOIN KichThuoc kt ON p.kichThuoc.id = kt.id"
//				+ " INNER JOIN GioiTinh gt ON p.gioiTinh.id = gt.id" 
//				+ " WHERE (p.name LIKE :pname and p.category.id = :cId and p.thuongHieu.name LIKE :thname and p.kichThuoc.name LIKE :ktname and p.gioiTinh.name LIKE :gtname"
//				+ " and (p.price between :priceStart AND :priceEnd))";
//		
//		
//		return entityManager.createQuery(jql, Product.class).setParameter("pname", "%" + findName + "%")
//				.setParameter("thname", "%" + thuongHieuName + "%")
//				.setParameter("ktname", "%" + kichThuocName + "%")
//				.setParameter("gtname", "%" + gioiTinhName + "%")
//				.setParameter("priceStart", priceStart).setParameter("priceEnd", priceEnd)
//				.setParameter("cId", categoryId)
//				.setFirstResult(start).setMaxResults(length).getResultList();
//	}
//
//}
