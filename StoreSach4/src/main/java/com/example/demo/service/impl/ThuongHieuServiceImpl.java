//package com.example.demo.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dao.ThuongHieuDao;
//import com.example.demo.entity.ThuongHieu;
//import com.example.demo.model.ThuongHieuDTO;
//import com.example.demo.service.ThuongHieuService;
//
//
//@Transactional
//@Service
//public class ThuongHieuServiceImpl implements ThuongHieuService{
//	
//	@Autowired
//	private ThuongHieuDao thuongHieuDao;
//
//	@Override
//	public void insert(ThuongHieuDTO thuongHieuDTO) {
//		ThuongHieu thuongHieu = new ThuongHieu();
//		thuongHieu.setName(thuongHieuDTO.getName());
//		thuongHieuDao.insert(thuongHieu);
//		thuongHieuDTO.setId(thuongHieu.getId());
//		
//	}
//
//	@Override
//	public void update(ThuongHieuDTO thuongHieuDTO) {
//		ThuongHieu thuongHieu = thuongHieuDao.get(thuongHieuDTO.getId());
//		if(thuongHieu != null) {
//			thuongHieu.setName(thuongHieuDTO.getName());
//			
//			thuongHieuDao.update(thuongHieu);
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		ThuongHieu thuongHieu = thuongHieuDao.get(id);
//		if(thuongHieu != null) {
//			thuongHieuDao.delete(thuongHieu);
//		}
//	}
//
//	@Override
//	public ThuongHieuDTO get(int id) {
//		ThuongHieu thuongHieu = thuongHieuDao.get(id);
//		
//		if(thuongHieu != null) {
//			ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
//			thuongHieuDTO.setId(thuongHieu.getId());
//			thuongHieuDTO.setName(thuongHieu.getName());
//			
//			return thuongHieuDTO;
//		}
//		return null;
//	}
//
//	@Override
//	public List<ThuongHieuDTO> search(String name, int start, int length) {
//		List<ThuongHieu> thuongHieus = thuongHieuDao.search(name, start, length);
//		List<ThuongHieuDTO> thuongHieuDTOs = new ArrayList<ThuongHieuDTO>();
//		
//		for(ThuongHieu thuongHieu : thuongHieus) {
//			ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
//			thuongHieuDTO.setId(thuongHieu.getId());
//			thuongHieuDTO.setName(thuongHieu.getName());
//			
//			thuongHieuDTOs.add(thuongHieuDTO);
//		}
//		return thuongHieuDTOs;
//	}
//
//}
