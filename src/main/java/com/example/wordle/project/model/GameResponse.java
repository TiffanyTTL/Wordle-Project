package com.example.wordle.project.model;

import com.example.wordle.project.requestbody.SubmitGuessRequestBody;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * GameResponse model class.
 */
@Document("GameResponse")
public class GameResponse {

  /**
   * GameResponse fields.
   */
  @Id
  @Indexed(unique = true)
  private String gameResponseId;
  private int currentTries;
  private String wordGuess;
  private GameStatus gameStatus;
  private CharacterStatus characterStatus;

  public GameResponse() {
  }
  /**
   * GameResponse constructor.
   */

  public GameResponse(int currentTries, String wordGuess, GameStatus gameStatus) {
    super();
    this.currentTries = currentTries;
    this.wordGuess = wordGuess;
    this.gameStatus = gameStatus;



  }

  public GameResponse( SubmitGuessRequestBody submitGuessRequestBody,
                       GameStatus gameStatus, CharacterStatus characterStatus) {
    this.wordGuess = submitGuessRequestBody.getGuessResponse();
    this.gameStatus = gameStatus;
    this.characterStatus = characterStatus;
  }

  public int getCurrentTries() {
    return currentTries ++ ;
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


  public GameStatus getGameStatus() {
    return gameStatus;
  }

  public void setGameStatus(GameStatus gameStatus) {
    this.gameStatus = gameStatus;
  }


}
