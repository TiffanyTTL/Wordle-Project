package com.example.wordle.project.service;


import com.example.wordle.project.controller.UserController;
import com.example.wordle.project.model.*;
import com.example.wordle.project.repository.UserRepository;
import com.example.wordle.project.repository.WordOfTheDayRepository;
import com.example.wordle.project.requestbody.SubmitGuessRequestBody;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * User service class.
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private WordOfTheDayRepository wordOfTheDayRepository;

  User user;

  Game game;

  WordOfTheDay wordOfTheDay;

  Logger logger = LoggerFactory.getLogger(UserController.class);


  /**
   * constructor generated for the user service class.
   */
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserService() {}


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
  /**
   * submit guess method class.
   */

  public GameResponse submitGuessResponse(SubmitGuessRequestBody submitGuessRequestBody) {
    User user =
            userRepository.findUserByUserEmailAddress(submitGuessRequestBody.getUserEmailAddress());
    WordOfTheDay wordOfTheDay =
            wordOfTheDayRepository.findWordOfTheDayByDate(submitGuessRequestBody.getDate());

    String userGame = Optional.of(user.getUserEmailAddress(
            submitGuessRequestBody.getUserEmailAddress()))
            .orElseThrow(() -> new RuntimeException("session doesn't exist"));
    if (game.getCurrentTries() > 5) {
      throw new RuntimeException("Game finished, please play again");
    }

    int currentTry = game.getCurrentTries();
    game.setCurrentTries(++currentTry);
    String userWord = game.getWord();
    if (Objects.equals(wordOfTheDay.getWordOfTheDay(), submitGuessRequestBody)) {

      return new GameResponse(currentTry, submitGuessRequestBody,
              CharacterStatus.CORRECT, GameStatus.WIN);

    }

    else {
      return new GameResponse(
              currentTry, submitGuessRequestBody, CharacterStatus.NOT_PRESENT, GameStatus.LOSE);
    }

  }

}

