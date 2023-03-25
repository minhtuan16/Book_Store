//package com.example.demo.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.dao.CategoryDao;
//import com.example.demo.entity.Category;
//import com.example.demo.model.CategoryDTO;
//import com.example.demo.service.CategoryService;
//
//@Transactional
//@Service
//
//public class CategoryServiceImpl implements CategoryService {
//
//	@Autowired
//	CategoryDao categoryDao;
//	
//	@Override
//	public void insert(CategoryDTO categoryDTO) {
//		// TODO Auto-generated method stub
//		Category category = new Category();
//		category.setNameCategory(categoryDTO.getNameCategory());
//		categoryDao.insert(category);
//		categoryDTO.setId(category.getId());
//	}
//
//	@Override
//	public void update(CategoryDTO categoryDTO) {
//		// TODO Auto-generated method stub
//		Category category = categoryDao.get(categoryDTO.getId());
//		
//		if (category != null) {
//			category.setNameCategory(categoryDTO.getNameCategory());
//			
//			categoryDao.update(category);
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		// TODO Auto-generated method stub
//		Category category = categoryDao.get(id);
//		
//		if(category != null) {
//			categoryDao.delete(category);
//		}
//	}
//
//	@Override
//	public CategoryDTO get(int id) {
//		// TODO Auto-generated method stub
//		Category category = categoryDao.get(id);
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setId(category.getId());
//		categoryDTO.setNameCategory(category.getNameCategory());
//		
//		return categoryDTO;
//	}
//
//	@Override
//	public List<CategoryDTO> search(String nameCategory, int start, int length) {
//		// TODO Auto-generated method stub
//		List<Category> categories = categoryDao.search(nameCategory, start, length);
//		
//		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
//		
//		for(Category category : categories) {
//			CategoryDTO categoryDTO = new CategoryDTO();
//			
//			categoryDTO.setId(category.getId());
//			categoryDTO.setNameCategory(category.getNameCategory());
//			
//			categoryDTOs.add(categoryDTO);
//		}
//		
//		return categoryDTOs;
//	}
//	
//}
