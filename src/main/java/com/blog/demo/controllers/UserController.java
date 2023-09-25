package com.blog.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.demo.models.User;
import com.blog.demo.payloads.ApiResponse;
import com.blog.demo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	//Post- Create User 
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User user1=userService.createUser(user);
		return new ResponseEntity<User>(user1,HttpStatus.CREATED);
		
	}
	
	
	//Put- Update User
	
	@PutMapping("/{userid}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int userid){
		
		User user1=userService.updateUser(user, userid);
		return ResponseEntity.ok(user1);
		
	}
	
	//DELETE delete User
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable int userid){
		
	 userService.deleteUser(userid);
	 
		return ResponseEntity.ok(new ApiResponse("User Deleted",true));
		
	}
	
	
	
	
	//Get get User
	
	@GetMapping("/{userid}")
	public ResponseEntity<User> getUser(@PathVariable int userid){
		
	User user=userService.getUserById(userid);
	 
		return ResponseEntity.ok(user);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser(){
		
	 return ResponseEntity.ok(userService.getAllUser());
	 
		
	}
	
	
	
}
