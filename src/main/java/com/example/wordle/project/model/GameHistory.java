package com.example.wordle.project.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * GameResponse model class.
 */
@Document("GameHistory")
public class GameHistory {


    private String userEmailAddress;
    private int gamePlays;
    private LocalDate wordGuess;

    public GameHistory(String userEmailAddress, int gamePlays, LocalDate wordGuess) {
        this.userEmailAddress = userEmailAddress;
        this.gamePlays = gamePlays;
        this.wordGuess = wordGuess;
    }

    public GameHistory(){
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public int getGamePlays() {
        return gamePlays;
    }


    public void setGamePlays(int gamePlays) {
        this.gamePlays = gamePlays;
    }

    public LocalDate getWordGuess() {
        return wordGuess;
    }

    public void setWordGuess(LocalDate wordGuess) {
        this.wordGuess = wordGuess;
    }
}
