package com.blog.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.demo.models.Category;
import com.blog.demo.models.User;
import com.blog.demo.payloads.ApiResponse;
import com.blog.demo.services.CategoryService;
import com.blog.demo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	
		@Autowired
		private CategoryService categoryService;
		
		//Post- Create Category 
		
		@PostMapping("/")
		public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){
			
			Category category2=categoryService.createCategory(category);
			return new ResponseEntity<Category>(category2,HttpStatus.CREATED);
			
		}
		
		//PUT- Category
		
		@PutMapping("/{categoryId}")
		public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category,@PathVariable int categoryId){
			
			Category category2=categoryService.updateCategory(category,categoryId);
			return ResponseEntity.ok(category2);
			
		}
		
		//deleteMapping- 
		
		
		@DeleteMapping("/{categoryId}")
		public ResponseEntity<?> deleteCategory(@PathVariable int categoryId){
			
		 categoryService.deleteCategory(categoryId);
		 
			return ResponseEntity.ok(new ApiResponse("Category Deleted",true));
			
		}
		
		@GetMapping("/{categoryId}")
		public ResponseEntity<Category> getCategory(@PathVariable int categoryId){
			
			Category category=categoryService.getCategory(categoryId);
			return ResponseEntity.ok(category);
			
		}
		
		@GetMapping("/")
		public ResponseEntity<List<Category>> getAllCategory(){
			
			
			
			return ResponseEntity.ok(categoryService.getAllCategory());
			
		}

}
