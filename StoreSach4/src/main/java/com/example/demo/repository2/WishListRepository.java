package com.example.demo.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity2.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long>{
	WishList findBySessionToken(String sessionToken);
}
