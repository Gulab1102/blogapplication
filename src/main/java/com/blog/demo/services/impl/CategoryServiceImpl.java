package com.blog.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.demo.exceptions.ResoureNotFoundException;
import com.blog.demo.models.Category;
import com.blog.demo.repository.CategoryRepo;
import com.blog.demo.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category, int categoryId) {
		// TODO Auto-generated method stub
		Category category2=categoryRepo.findById(categoryId).orElseThrow(()->
        new ResoureNotFoundException("Category","Id",categoryId));
		
		category2.setCategoryDescription(category.getCategoryDescription());
		category2.setCategoryTitle(category.getCategoryTitle());
		
		return categoryRepo.save(category2);
	}

	@Override
	public void deleteCategory(int categoryId) {
		
		Category category=categoryRepo.findById(categoryId).orElseThrow(()->
        new ResoureNotFoundException("Category","Id",categoryId));
		
		categoryRepo.delete(category);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(categoryId).orElseThrow(()->
        new ResoureNotFoundException("Category","Id",categoryId));
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

}
