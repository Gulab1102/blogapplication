package com.blog.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.demo.models.Category;
import com.blog.demo.models.Post;
import com.blog.demo.models.User;

import jakarta.transaction.Transactional;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
	
	
	
	
	@Transactional
	@Modifying
	@Query(value="delete from blog_app_api.Post p where p.post_Id = :postId", nativeQuery = true)
	void deletePost(@Param("postId")int postId);
	
	
	
	

}
