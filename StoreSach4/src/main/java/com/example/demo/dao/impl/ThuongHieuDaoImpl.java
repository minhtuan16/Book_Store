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
//import com.example.demo.dao.ThuongHieuDao;
//import com.example.demo.entity.ThuongHieu;
//
//@Transactional
//@Repository
//
//public class ThuongHieuDaoImpl implements ThuongHieuDao {
//
//	@PersistenceContext
//	EntityManager entityManager;
//	
//	@Override
//	public void insert(ThuongHieu thuongHieu) {
//		entityManager.persist(thuongHieu);
//	}
//
//	@Override
//	public void update(ThuongHieu thuongHieu) {
//		entityManager.merge(thuongHieu);
//	}
//
//	@Override
//	public void delete(ThuongHieu thuongHieu) {
//		entityManager.remove(thuongHieu);
//	}
//
//	@Override
//	public ThuongHieu get(int id) {
//		return entityManager.find(ThuongHieu.class, id);
//	}
//
//	@Override
//	public List<ThuongHieu> search(String findName) {
//		
//		String jql = "SELECT c FROM ThuongHieu c WHERE c.name LIKE :name";
//		return entityManager.createQuery(jql, ThuongHieu.class).setParameter("name", "%" + findName + "%").getResultList();
//	}
//
//	@Override
//	public List<ThuongHieu> search(String findName, int start, int length) {
//		String jql = "SELECT c FROM ThuongHieu c WHERE c.name LIKE :name";
//		return entityManager.createQuery(jql, ThuongHieu.class).setParameter("name", "%" + findName + "%")
//				.setFirstResult(start).setMaxResults(length).getResultList();
//		
//	}
//
//	@Override
//	public int count(String findName) {
//		String jql = "SELECT count(c) FROM ThuongHieu c WHERE c.name LIKE :name";
//		return entityManager.createQuery(jql, Integer.class).setParameter("name", "%" + findName + "%").getSingleResult();
//	}
//
//}
