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
//import com.example.demo.dao.GioiTinhDao;
//import com.example.demo.entity.GioiTinh;
//
//@Transactional
//@Repository
//
//public class GioiTinhDaoImpl implements GioiTinhDao {
//
//	@PersistenceContext
//	EntityManager entityManager;
//	
//	@Override
//	public void insert(GioiTinh gioiTinh) {
//		entityManager.persist(gioiTinh);
//	}
//
//	@Override
//	public void update(GioiTinh gioiTinh) {
//		entityManager.merge(gioiTinh);
//	}
//
//	@Override
//	public void delete(int id) {
//		entityManager.remove(getById(id));
//	}
//
//	@Override
//	public GioiTinh getById(int id) {
//		return entityManager.find(GioiTinh.class, id);
//	}
//
//	@Override
//	public List<GioiTinh> search(String name, int start, int length) {
//
//		String jql = "SELECT c FROM GioiTinh c WHERE c.name LIKE :cname";
//		
//		return entityManager.createQuery(jql, GioiTinh.class).setParameter("cname", "%" + name + "%").setFirstResult(start).setMaxResults(length).getResultList();
//	}
//
//}
