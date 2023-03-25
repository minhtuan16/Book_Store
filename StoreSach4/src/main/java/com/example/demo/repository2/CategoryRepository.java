package com.example.demo.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity2.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	public Category findByName(String name);

}
