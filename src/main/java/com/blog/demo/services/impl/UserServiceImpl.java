package com.blog.demo.services.impl;

import com.blog.demo.exceptions.ResoureNotFoundException;
import com.blog.demo.models.User;
import com.blog.demo.repository.UserRepo;
import com.blog.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user, int id) {
        User user1=userRepo.findById(id).orElseThrow(()->
        new ResoureNotFoundException("User","Id",id));
        
       user1.setId(id);
       user1.setEmail(user.getEmail());
       user1.setName(user.getName());
       user1.setPassword(user.getPassword());
       

        return userRepo.save(user1);
    }
    
    

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(()->
        new ResoureNotFoundException("User","Id",id));
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(int id) {
    	
    	User user=userRepo.findById(id).orElseThrow(()->
        new ResoureNotFoundException("User","Id",id));
    	
    	userRepo.delete(user);

    }
}
