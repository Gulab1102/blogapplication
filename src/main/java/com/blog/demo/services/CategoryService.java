package com.blog.demo.services;

import java.util.List;

import com.blog.demo.models.Category;

public interface CategoryService {
	
	//create 
	Category createCategory(Category category);
	
	//update
	
	Category updateCategory(Category category,int  categoryId);
	
	//delete
	
	void deleteCategory(int  categoryId);
	
	//get 
	Category getCategory(int  categoryId);
	
	//getall
	
	List<Category> getAllCategory();
	
	

}
