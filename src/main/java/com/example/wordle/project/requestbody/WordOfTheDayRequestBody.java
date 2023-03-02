package com.example.wordle.project.requestbody;

import java.time.LocalDate;

public class WordOfTheDayRequestBody {

    public String wordOfTheDay;

    public LocalDate wordOfTheDayDate;

    public WordOfTheDayRequestBody(String wordOfTheDay, LocalDate wordOfTheDayDate) {
        this.wordOfTheDay = wordOfTheDay;
        this.wordOfTheDayDate = wordOfTheDayDate;
    }

    public String getWordOfTheDay() {
        return wordOfTheDay;
    }

    public void setWordOfTheDay(String wordOfTheDay) {
        this.wordOfTheDay = wordOfTheDay;
    }

    public LocalDate getWordOfTheDayDate() {
        return wordOfTheDayDate;
    }

    public void setWordOfTheDayDate(LocalDate wordOfTheDayDate) {
        this.wordOfTheDayDate = wordOfTheDayDate;
    }


}
