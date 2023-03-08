package com.example.wordle.project.requestbody;

import java.time.LocalDate;

public class SubmitGuessRequestBody {


    public SubmitGuessRequestBody() {

    }

    public String guessResponse;
    public String userEmailAddress;
    public LocalDate date;

    public SubmitGuessRequestBody(String guessResponse, String userEmailAddress, LocalDate date) {
        this.guessResponse = guessResponse;
        this.userEmailAddress = userEmailAddress;
        this.date = date;
    }

    public String getGuessResponse() {
        return guessResponse;
    }
    public void setGuessResponse(String guessResponse) {
        this.guessResponse = guessResponse;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
