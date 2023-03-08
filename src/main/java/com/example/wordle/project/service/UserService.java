package com.example.wordle.project.service;


import com.example.wordle.project.controller.UserController;
import com.example.wordle.project.model.*;
import com.example.wordle.project.repository.GameHistoryRepository;
import com.example.wordle.project.repository.GamesResponseRepo;
import com.example.wordle.project.repository.UserRepository;
import com.example.wordle.project.repository.WordOfTheDayRepository;
import com.example.wordle.project.requestbody.StartGameRequestBody;
import com.example.wordle.project.requestbody.SubmitGuessRequestBody;
import java.time.LocalDate;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.wordle.project.model.GameStatus.*;



/**
 * User service class.
 */
@Service
public class UserService {


  private final UserRepository userRepository;

  private final WordOfTheDayRepository wordOfTheDayRepository;

  private final GameHistoryRepository gameHistoryRepository;


  public Game game;

  WordOfTheDay wordOfTheDay;

  GameResponse gameResponse;

  Logger logger = LoggerFactory.getLogger(UserController.class);



  User user;

  /**
   * constructor generated for the user service class.
   */



  public UserService(UserRepository userRepository, WordOfTheDayRepository wordOfTheDayRepository, GameHistoryRepository gameHistoryRepository) {

    this.userRepository = userRepository;
    this.wordOfTheDayRepository = wordOfTheDayRepository;
    this.gameHistoryRepository = gameHistoryRepository;
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

    public String addGameToDatabase(StartGameRequestBody startGameRequestBody) {
   User user = userRepository.findUserByUserEmailAddress(startGameRequestBody.getUserEmailAddress());
    return user.getUserEmailAddress() + " has started Wordle\"";

//    this.user = userRepository.findUserByUserEmailAddress(
//            startGameRequestBody.getUserEmailAddress()); //get username
//    this.wordOfTheDay = wordOfTheDayRepository.findWordOfTheDayByDate(LocalDate.now());
//    return String.valueOf(startGameRequestBody);
  }

  /**
   * submit guess method class.
   */

  public GameResponse submitGuessResponse(SubmitGuessRequestBody submitGuessRequestBody) {
    WordOfTheDay wordOfTheDay =
            wordOfTheDayRepository.findWordOfTheDayByDate(submitGuessRequestBody.getDate());
    GameHistory gameHistory =
            gameHistoryRepository.findGameHistoriesByUserEmailAddress(
                    submitGuessRequestBody.getUserEmailAddress(),(LocalDate.now()));

    if(gameHistory == null) {
      gameHistory = new GameHistory();
      gameHistory.setUserEmailAddress(gameHistory.getUserEmailAddress());
      gameHistory.setWordGuess(LocalDate.now());
      gameHistory.setCurrentTries(0);
      }


    //check if user exists
     User userDetails = userRepository.findUserByUserEmailAddress(
             submitGuessRequestBody.getUserEmailAddress());
      Game userGame = new Game(submitGuessRequestBody.getGuessResponse(), gameHistory.getCurrentTries(),userDetails.getUserEmailAddress());

    if (userDetails.equals(new User())) {
      throw new RuntimeException("User doesn't exist");
    }

    //check current tries
    if (userGame.getCurrentTries() > 5) {
      throw new RuntimeException("Session over, please try again");
    }
    //check that the word matches word of the day
    // Correct position - if the character is the same as the word of the day
    // Position Error - if the character is present in the word of the day however, it's in the incorrect position
    // Wrong - character does not exist

    int currentAttemptCount = userGame.getCurrentTries();
    userGame.setCurrentTries(++currentAttemptCount);
   String usersWord = userGame.getWord();
    Map<String, CharacterStatus> characterValueMap = new HashMap<>();
    System.out.println(usersWord);
    System.out.println(wordOfTheDay.getWordOfTheDay());
    if (usersWord.equalsIgnoreCase(wordOfTheDay.getWordOfTheDay())) {
      return new GameResponse(submitGuessRequestBody, WIN, null);
    }
    else {
      Set<Character> checkingCharacter = new HashSet<>();
      for (int i = 0; i < usersWord.length(); i++)
        checkingCharacter.add(usersWord.charAt(i));
      for (int i=0;i < usersWord.length();i++)
      {
        if (usersWord.charAt(i)==wordOfTheDay.getWordOfTheDay().charAt(i)) {
          characterValueMap.put(String.valueOf(wordOfTheDay.getWordOfTheDay().charAt(i)), CharacterStatus.CORRECT);
        } else if (checkingCharacter.contains(wordOfTheDay.getWordOfTheDay().charAt(i))) {
        characterValueMap.put(String.valueOf(wordOfTheDay.getWordOfTheDay().charAt(i)), CharacterStatus.PRESENT_BUT_POSITION_ERROR);
        } else {
          characterValueMap.put(String.valueOf(wordOfTheDay.getWordOfTheDay().charAt(i)), CharacterStatus.NOT_PRESENT);
        }
      }
      return new GameResponse(submitGuessRequestBody, IN_PROGRESS, null);

        }
      }
    }


