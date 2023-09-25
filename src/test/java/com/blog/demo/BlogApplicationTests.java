package com.blog.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.demo.repository.UserRepo;

@SpringBootTest
class BlogApplicationTests {
	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
    public void repotest() {
		
		System.out.println(userRepo.getClass().getName());
		
		System.out.println(userRepo.getClass().getPackageName());
    	
    }
    
}
