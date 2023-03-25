package com.example.demo.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity2.KichThuoc;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Long> {
	public KichThuoc findByName(String name);

}
