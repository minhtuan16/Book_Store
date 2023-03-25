package com.example.demo.service2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity2.Category;
import com.example.demo.entity2.Coupon;
import com.example.demo.entity2.GioiTinh;
import com.example.demo.entity2.KichThuoc;
import com.example.demo.entity2.ThuongHieu;
import com.example.demo.repository2.CategoryRepository;
import com.example.demo.repository2.CouponRepository;
import com.example.demo.repository2.GioiTinhRepository;
import com.example.demo.repository2.KichThuocRepository;
import com.example.demo.repository2.ThuongHieuRepository;

@Service

public class Cate_TH_KT_GT_Coupon_Service {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private GioiTinhRepository gioiTinhRepository;

	@Autowired
	private ThuongHieuRepository thuongHieuRepository;
	
	@Autowired
	private KichThuocRepository kichThuocRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	
	public List<GioiTinh> getAllGioiTinh()
	{
		return gioiTinhRepository.findAll();
	} 

	public List<Category> getAllCategory()
	{
		return categoryRepository.findAll();
	}
	

	public List<ThuongHieu> getAllThuongHieu()
	{
		return thuongHieuRepository.findAll();
	} 

	public List<KichThuoc> getAllKichThuoc()
	{
		return kichThuocRepository.findAll();
	} 
	
	public List<Coupon> getAllCoupon()
	{
		return couponRepository.findAll();
	} 
}
