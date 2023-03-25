  package com.example.demo.repository2;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity2.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

//	@Query("SELECT ct FROM CartItem ct JOIN ct.product p JOIN ct.shoppingCart sc WHERE sc.id = :ctId")
//	Page<CartItem> searchByShoppingCart(@Param("ctId") Long ctId, Pageable pageable);
//	List<CartItem> searchByShoppingCart(@Param("ctId") Long ctId);
	
}
 