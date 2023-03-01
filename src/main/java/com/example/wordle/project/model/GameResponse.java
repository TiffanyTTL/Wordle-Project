package com.example.wordle.project.model;

import java.util.Map;

/**
 * GameResponse model class.
 */
public class GameResponse {

  /**
   * GameResponse fields.
   */
  private int currentTries;
  private String wordGuess;
  private String userEmailAddress;
  private GameStatus gameStatus;
  private Map<String, WordStatus> wordStatusMap;

  /**
   * GameResponse constructor.
   */
  public GameResponse(int currentTries, String wordGuess, String userEmailAddress,
                      GameStatus gameStatus,
                      Map<String, WordStatus> wordStatusMap) {
    super();
    this.currentTries = currentTries;
    this.wordGuess = wordGuess;
    this.userEmailAddress = userEmailAddress;
    this.gameStatus = gameStatus;
    this.wordStatusMap = wordStatusMap;

  }

  public int getCurrentTries() {
    return currentTries;
  }

  public void setCurrentTries(int currentTries) {
    this.currentTries = currentTries;
  }

  public String getWordGuessWord() {
    return wordGuess;
  }

  public void setWordGuess(String wordGuess) {
    this.wordGuess = wordGuess;
  }

  public String getUserEmailAddress() {
    return userEmailAddress;
  }

  public void setUserEmailAddress(String userEmailAddress) {
    this.userEmailAddress = userEmailAddress;
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  public void setGameStatus(GameStatus gameStatus) {
    this.gameStatus = gameStatus;
  }

  public Map<String, WordStatus> getWordStatusMap() {
    return wordStatusMap;
  }

  public void setWordStatusMap(Map<String, WordStatus> wordStatusMap) {
    this.wordStatusMap = wordStatusMap;
  }

}
