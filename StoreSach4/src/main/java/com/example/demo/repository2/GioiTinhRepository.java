package com.example.demo.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity2.GioiTinh;

@Repository
public interface GioiTinhRepository extends JpaRepository<GioiTinh, Long> {
	public GioiTinh findByName(String name);

}
