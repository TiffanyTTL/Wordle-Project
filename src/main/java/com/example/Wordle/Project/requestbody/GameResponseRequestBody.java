package com.example.Wordle.Project.requestbody;

/**
 * GameResponseRequestBody class.
 */
public class GameResponseRequestBody {

  public String userEmailAddress;
  public int currentTries;
  public String wordGuess;
  public String wordStatus;
  public String gameStatus;

  /**
   * GameResponseRequestBody constructor.
   */
  public GameResponseRequestBody(String userEmailAddress, int currentTries,
                                 String wordGuess, String wordStatus, String gameStatus) {
    this.userEmailAddress = userEmailAddress;
    this.currentTries = currentTries;
    this.wordGuess = wordGuess;
    this.wordStatus = wordStatus;
    this.gameStatus = gameStatus;
  }


  public String getUserEmailAddress() {
    return userEmailAddress;
  }

  public void setUserEmailAddress(String userEmailAddress) {
    this.userEmailAddress = userEmailAddress;
  }

  public int getCurrentTries() {
    return currentTries;
  }

  public void setCurrentTries(int currentTries) {
    this.currentTries = currentTries;
  }

  public String getWordGuess() {
    return wordGuess;
  }

  public void setWordGuess(String wordGuess) {
    this.wordGuess = wordGuess;
  }

  public String getWordStatus() {
    return wordStatus;
  }

  public void setWordStatus(String wordStatus) {
    this.wordStatus = wordStatus;
  }

  public String getGameStatus() {
    return gameStatus;
  }

  public void setGameStatus(String gameStatus) {
    this.gameStatus = gameStatus;
  }

}
