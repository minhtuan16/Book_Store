//package com.example.demo.dao.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.dao.UserDao;
//import com.example.demo.entity2.User;
//
//@Transactional
//@Repository
//
//public class UserDaoImpl implements UserDao {
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public void insert(User user) {
//		entityManager.persist(user);
//	}
//
//	@Override
//	public void update(User user) {
//		entityManager.merge(user);
//	}
//
//	@Override
//	public void delete(User user) {
//		entityManager.remove(user);
//	}
//
//	@Override
//	public User get(int id) {
//		return entityManager.find(User.class, id);
//	}
//
//	@Override
//	public User getByUsername(String username) {
//		String jql = "SELECT u FROM User u WHERE u.username = :username ";
//		return entityManager.createQuery(jql, User.class).setParameter("username", username).getSingleResult();
//	}
//
//	@Override
//	public List<User> search(String findName, int start, int length) {
//		String jql = "SELECT u FROM User u WHERE name LIKE :name";
//		Query query = entityManager.createQuery(jql, User.class);
//		query.setParameter("name", "%" + findName + "%");
//		query.setFirstResult(start).setMaxResults(length);
//		return query.getResultList();
//	}
//
//}
