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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.demo.models.Post;
import com.blog.demo.models.User;
import com.blog.demo.payloads.ApiResponse;
import com.blog.demo.services.PostService;
import com.blog.demo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {
	
	//Post- Create User 
		@Autowired
		private PostService postService;
		
		@PostMapping("/user/{userId}/category/{categoryId}/posts/")
		public ResponseEntity<Post> createPost( @RequestBody Post post,@PathVariable int userId,@PathVariable
				 int categoryId){
			
			Post post1=postService.createPost(post,categoryId,userId);
			return new ResponseEntity<Post>(post1,HttpStatus.CREATED);
			
		}
		
		@GetMapping("/user/{userId}/posts/")
		public ResponseEntity<List<Post>> getPostByUser( @PathVariable int userId){
			
			List<Post> posts=postService.getPostByUser(userId);
			return new ResponseEntity<>(posts,HttpStatus.OK);
			
		}
		
		
		@GetMapping("/category/{categoryId}/posts")
		public ResponseEntity<List<Post>> getPostByCategory( @PathVariable int categoryId){
			
			List<Post> posts=postService.getPostByCategory(categoryId);
			return new ResponseEntity<>(posts,HttpStatus.OK);
			
		}
		
		@GetMapping("/posts")
		public ResponseEntity<List<Post>> getAllPost(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)
		int pageNumber,@RequestParam(value = "pageSize",defaultValue = "5",required = false)
		int pageSize
				){
			
			List<Post> posts=postService.getAllPost(pageNumber,pageSize);
			return new ResponseEntity<>(posts,HttpStatus.OK);
			
		}
		
		@GetMapping("/posts/{postId}")
		public ResponseEntity<Post> getPost(@PathVariable int postId){
			
			Post posts=postService.getPost(postId);
			return new ResponseEntity<>(posts,HttpStatus.OK);
			
		}
		
		@PutMapping("/posts/{postId}")
		public ResponseEntity<Post> updatePost(@RequestBody Post post,@PathVariable int postId){
			
			Post posts=postService.updatePost(post, postId);
			return new ResponseEntity<>(posts,HttpStatus.OK);
			
		}
		
		@DeleteMapping("/posts/{postId}")
		public ResponseEntity<ApiResponse> deletePost(@PathVariable int postId){
			
			postService.deletePost(postId);
			return new ResponseEntity<>(new ApiResponse("Deleted Successfully",true),HttpStatus.OK);
			
		}

}
