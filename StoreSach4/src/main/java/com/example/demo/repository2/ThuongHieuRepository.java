package com.example.demo.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity2.ThuongHieu;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Long> {
	public ThuongHieu findByName(String name);

}
