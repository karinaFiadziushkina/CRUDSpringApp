package com.app.crud.CarShopSpring.service;

import com.app.crud.CarShopSpring.model.User;
import com.app.crud.CarShopSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findById(Integer id) {
    return userRepository.getById(id);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public void saveUser(User user) {
    userRepository.save(user);
  }

  public void deleteById(Integer id) {
    userRepository.deleteById(id);
  }
}
