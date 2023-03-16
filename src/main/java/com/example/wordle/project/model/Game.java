package com.example.wordle.project.model;


import com.example.wordle.project.service.UserService;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Game model class.
 */
@Document("Game")
public class Game {
  private String word;
  private int currentTries;

  public String getUserEmailAddress() {
    return userEmailAddress;
  }

  public void setUserEmailAddress(String userEmailAddress) {
    this.userEmailAddress = userEmailAddress;
  }


  private String userEmailAddress;

  /**
   * Game constructor class.
   */
  public Game(String word, int currentTries, String userEmailAddress) {
    this.word = word;
    this.currentTries = currentTries;
    this.userEmailAddress = userEmailAddress;
  }

  public Game(){

  }


  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }


  public int getCurrentTries() {
    return currentTries;
  }


  public void setCurrentTries(int currentTries) {
    this.currentTries = currentTries;
  }

}
