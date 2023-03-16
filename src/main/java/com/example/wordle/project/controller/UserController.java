package com.example.wordle.project.controller;

import com.example.wordle.project.model.GameHistory;
import com.example.wordle.project.model.GameResponse;
import com.example.wordle.project.model.User;
import com.example.wordle.project.model.WordOfTheDay;
import com.example.wordle.project.repository.UserRepository;
import com.example.wordle.project.repository.WordOfTheDayRepository;
import com.example.wordle.project.requestbody.StartGameRequestBody;
import com.example.wordle.project.requestbody.SubmitGuessRequestBody;
import com.example.wordle.project.service.UserService;
import com.example.wordle.project.service.WordService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * User Controller class.
 */
@RestController
@Log4j2
@CrossOrigin
@RequestMapping("/user")
public class UserController {


  @Autowired
  UserService userService;

  @Autowired
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


  /**
   * Post request method for the user to start the game.
   */
  @PostMapping("/startGame")
  @ResponseStatus(HttpStatus.CREATED)
    public User startGame(StartGameRequestBody startGameRequestBody) {
    return userService.addGameToDatabase(startGameRequestBody);
  }


  /**
   * Post request method for the user to start the game.
   */
  @PostMapping("/submitGuess")
  @ResponseStatus(HttpStatus.OK)
  public GameResponse submitGuess(SubmitGuessRequestBody submitGuessRequestBody) {
    return userService.submitGuess(submitGuessRequestBody);
  }

  /**
   * Get request method to get the wordOfTheDay of the day.
   */
  @GetMapping("/user/{userEmailAddress}")
  @ResponseStatus(HttpStatus.OK)
  public GameHistory getUsersGameHistory(@PathVariable String userEmailAddress) {
    logger.info(("User history returned"));
    return userService.getUsersGameHistory(userEmailAddress);
  }

}
