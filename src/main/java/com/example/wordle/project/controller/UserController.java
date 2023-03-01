package com.example.wordle.project.controller;

import com.example.wordle.project.model.User;
import com.example.wordle.project.model.WordOfTheDay;
import com.example.wordle.project.repository.UserRepository;
import com.example.wordle.project.service.UserService;
import com.example.wordle.project.service.WordService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User Controller class.
 */
@RestController
@Log4j2
@CrossOrigin
@RequestMapping("/user")
public class UserController {


  private final UserService userService;

  WordService wordService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  Logger logger = LoggerFactory.getLogger(UserController.class);

  /**
   * Post request method to create a user.
   */
  @PostMapping("/createUser")
  @ResponseStatus(HttpStatus.CREATED)
  public User createUser(@RequestBody User user) {
    logger.info("User Created");
    return userService.createUser(user);
  }





}
