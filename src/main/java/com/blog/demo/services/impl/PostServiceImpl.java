package com.blog.demo.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.demo.exceptions.ResoureNotFoundException;
import com.blog.demo.models.Category;
import com.blog.demo.models.Post;
import com.blog.demo.models.User;
import com.blog.demo.repository.CategoryRepo;
import com.blog.demo.repository.PostRepo;
import com.blog.demo.repository.UserRepo;
import com.blog.demo.services.PostService;


@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
    private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Post createPost(Post post,int categoryId,int userId) {
		// TODO Auto-generated method stub
		
		 User user=userRepo.findById(userId).orElseThrow(()->
	        new ResoureNotFoundException("User","Id",userId));
		 
		 Category category=categoryRepo.findById(categoryId).orElseThrow(()->
	        new ResoureNotFoundException("Category","Id",categoryId));
		 
		 post.setUser(user);
		 
		 post.setAddDate(new Date());
		 
		 post.setCategory(category);
		 
		 
		return postRepo.save(post);
	}

	@Override
	public Post updatePost(Post post, int postId) {
		// TODO Auto-generated method stub
		Post post2=postRepo.findById(postId).orElseThrow(()->
        new ResoureNotFoundException("User","Id",postId));
		
		post2.setTitle(post.getTitle());
		
		post2.setContent(post.getContent());
		
		return postRepo.save(post2);
	}

	@Override
	public void deletePost(int postId) {
		// TODO Auto-generated method stub
		Post post2=postRepo.findById(postId).orElseThrow(()->
        new ResoureNotFoundException("Post","Id",postId));
		
		
		postRepo.deletePost(postId);
		
	}

	@Override
	public List<Post> getAllPost(int pagenumber,int pagesize) {
		// TODO Auto-generated method stub
		
		
		org.springframework.data.domain.Pageable p=PageRequest.of(pagenumber, 
				pagesize,Sort.by("postId").descending());
		
		Page<Post> posts=postRepo.findAll(p);
		return posts.getContent();
	}

	@Override
	public Post getPost(int postId) {
		// TODO Auto-generated method stub
		Post post=postRepo.findById(postId).orElseThrow(()->
        new ResoureNotFoundException("Category","Id",postId));
		return post;
	}

	@Override
	public List<Post> getPostByCategory(int categoryId) {
		// TODO Auto-generated method stub
		Category category=categoryRepo.findById(categoryId).orElseThrow(()->
        new ResoureNotFoundException("Category","Id",categoryId));
		return postRepo.findByCategory(category);
	}

	@Override
	public List<Post> getPostByUser(int userId) {
		// TODO Auto-generated method stub

		 User user=userRepo.findById(userId).orElseThrow(()->
	        new ResoureNotFoundException("User","Id",userId));
		return postRepo.findByUser(user);
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
