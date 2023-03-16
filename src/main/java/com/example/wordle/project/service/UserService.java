package com.example.wordle.project.service;


import com.example.wordle.project.controller.UserController;
import com.example.wordle.project.model.*;
import com.example.wordle.project.repository.GameHistoryRepository;
import com.example.wordle.project.repository.UserRepository;
import com.example.wordle.project.repository.WordOfTheDayRepository;
import com.example.wordle.project.requestbody.StartGameRequestBody;
import com.example.wordle.project.requestbody.SubmitGuessRequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


/**
 * User service class.
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private WordOfTheDayRepository wordOfTheDayRepository;

  @Autowired
  private GameHistoryRepository gameHistoryRepository;

  StartGameRequestBody startGameRequestBody;

  User user;

  Game game;

  WordOfTheDay wordOfTheDay;


  Logger logger = LoggerFactory.getLogger(UserController.class);

  /**
   * constructor generated for the user service class.
   */


  public UserService(UserRepository userRepository, WordOfTheDayRepository wordOfTheDayRepository, GameHistoryRepository gameHistoryRepository) {

    this.userRepository = userRepository;
    this.wordOfTheDayRepository = wordOfTheDayRepository;
    this.gameHistoryRepository = gameHistoryRepository;
    startGameRequestBody = new StartGameRequestBody();
    user = new User();
    game = new Game();
    wordOfTheDay = new WordOfTheDay();


  }

  /**
   * create user method class.
   */
  public User createUser(User user) {
    logger.info("Hello, welcome to the WORDLE!");
    //a request for the user to input their name
    logger.info("Please, enter your email address");
    userRepository.insert(user);
    return user;
  }

  public User addGameToDatabase(StartGameRequestBody startGameRequestBody) {
    user = userRepository.findUserByUserEmailAddress(startGameRequestBody.getUserEmailAddress());
    return user;
  }


  public User checkIfUserExists(String userEmailAddress) {
    User user = userRepository.findUserByUserEmailAddress(userEmailAddress);
    if (user == null) {
      throw new RuntimeException("user does not exist");
    }
      return user;
    }


     public Game ifUsersCurrentTriesIsOver5StopTheGame() {
       game = new Game(game.getWord(), game.getCurrentTries(), game.getUserEmailAddress());

       if (game.getCurrentTries() >= 5) {
         throw new RuntimeException();
       }
       return game;
     }


  public GameResponse submitGuess(SubmitGuessRequestBody submitGuessRequestBody) {

   WordOfTheDay wordOfTheDay = wordOfTheDayRepository.findWordOfTheDayByDate(LocalDate.now());
    String findUsersGuess = submitGuessRequestBody.getGuessResponse();

      if(findUsersGuess.length() != 5) {
        return new GameResponse(game.getCurrentTries(), game.getWord(), GameStatus.LOSE);
      }

      if(!wordOfTheDay.contains(findUsersGuess)) {
        return new GameResponse(game.getCurrentTries(), game.getWord(), GameStatus.LOSE);
      }

      CharacterStatus[] result = new CharacterStatus[wordOfTheDay.length()];
      for(int iter = 0 ; iter < findUsersGuess.length() ; iter++) {
        char currentChar = findUsersGuess.charAt(iter);
        if(currentChar == wordOfTheDay.charAt(iter)) {
          result[iter] = CharacterStatus.GREEN; //if correct green
          logger.info("success");
          continue;
        }
        if(wordOfTheDay.indexOf(currentChar) > -1) {
          result[iter] = CharacterStatus.YELLOW;
          continue;
        }
        result[iter] = CharacterStatus.BLACK;
      }
      return new GameResponse(game.getCurrentTries(), game.getWord(), GameStatus.LOSE);
    }
  }





//  public GameResponse submitGuessResponse(SubmitGuessRequestBody submitGuessRequestBody) {
//    GameHistory gameHistory =
//            gameHistoryRepository.findGameHistoriesByUserEmailAddress(
//                    submitGuessRequestBody.getUserEmailAddress(), (LocalDate.now()));
//
//    if (gameHistory == null) {
//      gameHistory = new GameHistory();
//      gameHistory.setUserEmailAddress(gameHistory.getUserEmailAddress());
//      gameHistory.setWordGuess(LocalDate.now());
//      gameHistory.setCurrentTries(1);
//    }
//
//    //check if user exists
//    User userDetails = userRepository.findUserByUserEmailAddress(
//            submitGuessRequestBody.getUserEmailAddress());
//    Game userGame = new Game(submitGuessRequestBody.getGuessResponse(), gameHistory.getCurrentTries(), userDetails.getUserEmailAddress());
//
//    if (userDetails.equals(new User())) {
//      throw new RuntimeException("User doesn't exist");
//    }
//
//    //check current tries
//    if (userGame.getCurrentTries() >= 5) {
//      throw new RuntimeException("Session over, please try again");
//    }
//
//  }
//  public
//
//  WordOfTheDay wordOfTheDay =
//          wordOfTheDayRepository.findWordOfTheDayByDate(submitGuessRequestBody.getDate());
//  //check that the word matches word of the day
//  // Correct position - if the character is the same as the word of the day
//  // Position Error - if the character is present in the word of the day however, it's in the incorrect position
//  // Wrong - character does not exist
//
//  int currentAttemptCount = userGame.getCurrentTries();
//    userGame.setCurrentTries(++currentAttemptCount);
//  String usersWord = userGame.getWord();
//  Map<String, CharacterStatus> characterValueMap = new HashMap<>();
//    System.out.println(usersWord);
//    System.out.println(wordOfTheDay.getWordOfTheDay());
//
//    if (usersWord.equalsIgnoreCase(wordOfTheDay.getWordOfTheDay())) {
//      return new GameResponse(submitGuessRequestBody, WIN, null);
//    }
//    else {
//      Set<Character> checkingCharacter = new HashSet<>();
//      for (int i = 0; i < usersWord.length(); i++)
//        checkingCharacter.add(usersWord.charAt(i));
//      for (int i=0;i < usersWord.length();i++)
//      {
//        if (usersWord.charAt(i)==wordOfTheDay.getWordOfTheDay().charAt(i)) {
//          characterValueMap.put(String.valueOf(wordOfTheDay.getWordOfTheDay().charAt(i)), CharacterStatus.CORRECT);
//        } else if (checkingCharacter.contains(wordOfTheDay.getWordOfTheDay().charAt(i))) {
//        characterValueMap.put(String.valueOf(wordOfTheDay.getWordOfTheDay().charAt(i)), CharacterStatus.PRESENT_BUT_POSITION_ERROR);
//        } else {
//          characterValueMap.put(String.valueOf(wordOfTheDay.getWordOfTheDay().charAt(i)), CharacterStatus.NOT_PRESENT);
//        }
//      }
//      return new GameResponse(submitGuessRequestBody, IN_PROGRESS, null);
//
//        }
//      }
//    }
//
//
