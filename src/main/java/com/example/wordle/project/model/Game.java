package com.example.wordle.project.model;



/**
 * Game model class.
 */
public class Game {
  private String word;
  private int currentTries;

  /**
   * Game constructor class.
   */
  public Game(String word, int currentTries) {
    super();
    this.word = word;
    this.currentTries = currentTries;
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
