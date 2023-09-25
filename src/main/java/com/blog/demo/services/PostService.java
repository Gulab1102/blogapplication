package com.blog.demo.services;

import java.util.List;

import com.blog.demo.models.Post;

public interface PostService {
	
	
	Post createPost(Post post,int categoryId,int userId);
	
	Post updatePost(Post post,int postId);
	
	void deletePost(int postId);
	
	List<Post> getAllPost(int pagenumber,int pagesize);
	
	Post getPost(int postId);
	
	List<Post> getPostByCategory(int categoryId);
	
	List<Post> getPostByUser(int userId);
	
	List<Post> searchPosts(String keyword);
	
	
	
	
	

}
