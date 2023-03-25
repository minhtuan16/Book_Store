//package com.example.demo.dao.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Join;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dao.ReviewDao;
//import com.example.demo.entity.Product;
//import com.example.demo.entity.Review;
//import com.example.demo.model.SearchReviewDTO;
//
//@Transactional
//@Repository
//
//public class ReviewDaoImpl implements ReviewDao {
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public void add(Review review) {
//		entityManager.persist(review);
//	}
//
//	@Override
//	public void delete(Review review) {
//		entityManager.remove(review);
//	}
//
//	@Override
//	public void edit(Review review) {
//		entityManager.merge(review);
//	}
//
//	@Override
//	public Review getById(int id) {
//		return entityManager.find(Review.class, id);
//	}
//
//	@Override
//	public List<Review> find(int productId) {
//		String jql="SELECT r FROM Review r JOIN r.user u JOIN r.product p WHERE p.id = :pid";
//		return entityManager.createQuery(jql, Review.class).setParameter("pid",productId ).getResultList();
//	}
//
//	@Override
//	public Long count(SearchReviewDTO searchReviewDTO) {
//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
//		Root<Review> root = criteriaQuery.from(Review.class);
//
//		List<Predicate> predicates = new ArrayList<Predicate>();
//
//
//		if (searchReviewDTO.getProductId() != 0) {
//			Join<Review, Product> product = root.join("product");
//			predicates.add(criteriaBuilder.equal(product.get("id"), searchReviewDTO.getProductId()));
//		}
//
//		criteriaQuery.where(predicates.toArray(new Predicate[] {}));
//		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
//		return typedQuery.getSingleResult();
//	}
//
//	@Override
//	public Long countTotal(SearchReviewDTO searchReviewDTO) {
//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
//		Root<Review> root = criteriaQuery.from(Review.class);
//
//		List<Predicate> predicates = new ArrayList<Predicate>();
//		criteriaQuery.where(predicates.toArray(new Predicate[] {}));
//
//		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
//		return typedQuery.getSingleResult();
//	}
//
//}
