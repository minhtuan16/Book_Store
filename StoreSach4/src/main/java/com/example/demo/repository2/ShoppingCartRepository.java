package com.example.demo.repository2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity2.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	ShoppingCart findBySessionToken(String sessionToken);

	@Query("SELECT sc FROM ShoppingCart sc JOIN sc.buyer b WHERE b.id = :scId")
	Page<ShoppingCart> searchByUserId(@Param("scId") Long scId, Pageable pageable);
}
