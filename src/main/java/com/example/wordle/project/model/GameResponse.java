package com.example.wordle.project.model;

import com.example.wordle.project.requestbody.SubmitGuessRequestBody;


/**
 * GameResponse model class.
 */
public class GameResponse {

  /**
   * GameResponse fields.
   */
  private int currentTries;
  private String wordGuess;
  private GameStatus gameStatus;
  private CharacterStatus characterStatus;

  public GameResponse() {
  }
  /**
   * GameResponse constructor.
   */

  public GameResponse(int currentTries, String wordGuess,
                      CharacterStatus characterStatus, GameStatus gameStatus) {
    super();
    this.currentTries = currentTries;
    this.wordGuess = wordGuess;
    this.characterStatus = characterStatus;
    this.gameStatus = gameStatus;


  }

  public GameResponse(int currentTry, SubmitGuessRequestBody submitGuessRequestBody,
                      CharacterStatus correct, GameStatus win) {
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

  public CharacterStatus getCharacterStatus() {
    return characterStatus;
  }

  public void setCharacterStatus(CharacterStatus characterStatus) {
    this.characterStatus = characterStatus;
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  public void setGameStatus(GameStatus gameStatus) {
    this.gameStatus = gameStatus;
  }


}
