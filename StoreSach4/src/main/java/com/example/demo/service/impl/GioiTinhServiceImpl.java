//package com.example.demo.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dao.GioiTinhDao;
//import com.example.demo.entity.GioiTinh;
//import com.example.demo.model.GioiTinhDTO;
//import com.example.demo.service.GioiTinhService;
//
//@Transactional
//@Service
//
//public class GioiTinhServiceImpl implements GioiTinhService {
//
//	@Autowired
//	private GioiTinhDao gioiTinhDao;
//	
//	@Override
//	public void insert(GioiTinhDTO gioiTinhDTO) {
//		GioiTinh gioiTinh = new GioiTinh();
//		
//		gioiTinh.setName(gioiTinhDTO.getName());
//		gioiTinhDao.insert(gioiTinh);
//		gioiTinhDTO.setId(gioiTinh.getId());
//	}
//
//	@Override
//	public void update(GioiTinhDTO gioiTinhDTO) {
//		GioiTinh gioiTinh = gioiTinhDao.getById(gioiTinhDTO.getId());
//		
//		if(gioiTinh != null) {
//			gioiTinh.setName(gioiTinhDTO.getName());
//			
//			gioiTinhDao.update(gioiTinh);
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		GioiTinh gioiTinh = gioiTinhDao.getById(id);
//		
//		if(gioiTinh != null) {
//			gioiTinhDao.delete(id);
//		}
//	}
//
//	@Override
//	public GioiTinhDTO getById(int id) {
//		GioiTinh gioiTinh = gioiTinhDao.getById(id);
//		
//		GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
//		gioiTinhDTO.setId(gioiTinh.getId());
//		gioiTinhDTO.setName(gioiTinh.getName());
//		
//		return gioiTinhDTO;
//	}
//
//	@Override
//	public List<GioiTinhDTO> search(String name, int start, int length) {
//
//		List<GioiTinh> gioiTinhs = gioiTinhDao.search(name, start, length);
//		
//		List<GioiTinhDTO> gioiTinhDTOs = new ArrayList<GioiTinhDTO>();
//		
//		for(GioiTinh gioiTinh :  gioiTinhs) {
//			GioiTinhDTO gioiTinhDTO = new GioiTinhDTO();
//			
//			gioiTinhDTO.setId(gioiTinh.getId());
//			gioiTinhDTO.setName(gioiTinh.getName());
//			
//			gioiTinhDTOs.add(gioiTinhDTO);
//		}
//		return gioiTinhDTOs;
//	}
//
//}
