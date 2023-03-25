//package com.example.demo.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dao.KichThuocDao;
//import com.example.demo.entity.KichThuoc;
//import com.example.demo.model.KichThuocDTO;
//import com.example.demo.service.KichThuocService;
//
//@Transactional
//@Service
//
//public class KichThuocServiceImpl implements KichThuocService {
//
//	@Autowired
//	private KichThuocDao kichThuocDao;
//
//	@Override
//	public void insert(KichThuocDTO kichThuocDTO) {
//		KichThuoc kichThuoc = new KichThuoc();
//
//		kichThuoc.setName(kichThuocDTO.getName());
//		kichThuocDao.insert(kichThuoc);
//		kichThuocDTO.setId(kichThuoc.getId());
//	}
//
//	@Override
//	public void update(KichThuocDTO kichThuocDTO) {
//		KichThuoc kichThuoc = kichThuocDao.get(kichThuocDTO.getId());
//		
//		if(kichThuoc != null) {
//			kichThuoc.setId(kichThuocDTO.getId());
//			kichThuoc.setName(kichThuocDTO.getName());
//			kichThuocDao.update(kichThuoc);
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		KichThuoc kichThuoc = kichThuocDao.get(id);
//		
//		if(kichThuoc != null) {
//			kichThuocDao.delete(kichThuoc);
//		}
//	}
//
//	@Override
//	public KichThuocDTO get(int id) {
//
//		KichThuoc kichThuoc = kichThuocDao.get(id);
//		
//		KichThuocDTO kichThuocDTO = new KichThuocDTO();
//		kichThuocDTO.setId(kichThuoc.getId());
//		kichThuocDTO.setName(kichThuoc.getName());
//		return kichThuocDTO;
//	}
//
//	@Override
//	public List<KichThuocDTO> search(String name, int start, int length) {
//		List<KichThuoc> kichThuocs = kichThuocDao.search(name, start, length);
//		
//		List<KichThuocDTO> kichThuocDTOList = new ArrayList<KichThuocDTO>();
//		
//		for(KichThuoc kichThuoc : kichThuocs) {
//			KichThuocDTO kichThuocDTO = new KichThuocDTO();
//			kichThuocDTO.setId(kichThuoc.getId());
//			kichThuocDTO.setName(kichThuoc.getName());
//			
//			kichThuocDTOList.add(kichThuocDTO);
//		}
//		
//		return kichThuocDTOList;
//	}
//
//}
