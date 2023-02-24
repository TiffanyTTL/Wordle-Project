package com.example.Wordle.Project.controller;

import com.example.Wordle.Project.model.User;
import com.example.Wordle.Project.repository.UserRepository;
import com.example.Wordle.Project.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller class.
 */
@RestController
@Log4j2
@RequestMapping("/user")
public class UserController {

  @Autowired
  private final UserService userService;

  @Autowired
  UserRepository userRepository;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  Logger logger = LoggerFactory.getLogger(UserController.class);

  /**
   * Post request method to create a user.
   */
  @PostMapping("/createUser")
  public String createUser(@RequestBody User user) {
    logger.info("User Created");
    return userService.createUser(user);

  }
}
