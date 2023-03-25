package com.example.demo.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity2.WishListItem;

@Repository
public interface WishListItemRepository extends JpaRepository<WishListItem,Long> {

}
