package com.app.crud.CarShopSpring.controller;

import com.app.crud.CarShopSpring.model.User;
import com.app.crud.CarShopSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public String findAll(Model model) {
    List<User> users = userService.findAll();
    model.addAttribute("users", users);
    return "user_list";
  }

  @GetMapping("/user_create")
  public String createUserForm(User user) {
    return "user_create";
  }

  @PostMapping("/user_create")
  public String createUser(User user) {
    userService.saveUser(user);
    return "redirect:/users";
  }

  @GetMapping("/user_delete/{id}")
  public String deleteUser(@PathVariable("id") Integer id){
    userService.deleteById(id);
    return "redirect:/users";
  }

  @GetMapping("/user_update/{id}")
  public String updateUserForm(@PathVariable("id") Integer id, Model model){
    User user = userService.findById(id);
    model.addAttribute("user", user);
    return "user_update";
  }

  @PostMapping("/user_update")
  public String updateUser(User user){
    userService.saveUser(user);
    return "redirect:/users";
  }
}
