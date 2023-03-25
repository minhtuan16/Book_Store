package com.example.demo.repository2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity2.User;

public interface UserRepo extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.username LIKE :x")
	Page<User> searchUsername(@Param("x") String x, Pageable pageable);
	
	User findByUsername(String s);
}
