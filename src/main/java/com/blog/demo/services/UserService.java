package com.blog.demo.services;

import com.blog.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

  public User createUser(User user);

  User updateUser(User user, int id);
  User getUserById(int id);
  List<User> getAllUser();
  void deleteUser(int id);



}
