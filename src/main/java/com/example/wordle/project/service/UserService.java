package com.example.wordle.project.service;

import com.example.wordle.project.controller.UserController;
import com.example.wordle.project.model.*;
import com.example.wordle.project.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * User service class.
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  User user;

  Game game;

  Logger logger = LoggerFactory.getLogger(UserController.class);


  /**
   * constructor generated for the user service class.
   */
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  /**
   * create user method class.
   */
  public User createUser(User user) {
    System.out.println("Hello, welcome to the WORDLE!");
    //a request for the user to input their name
    System.out.print("Please, enter your email address");
    userRepository.insert(user);
    return user;

  }

}