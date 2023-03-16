package com.example.wordle.project.model;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Word of the day model class.
 */
@Document("Word of the day")
public class WordOfTheDay {

  @Field(name = "wordOfTheDay")
  public String wordOfTheDay;

  @Field(name = "date")
  @JsonFormat(pattern = "yyyy-MM-dd")
  public LocalDate date;

  public WordOfTheDay() {
  }

  public WordOfTheDay(String wordOfTheDay, LocalDate date) {
    this.wordOfTheDay = wordOfTheDay;
    this.date = date;
  }

  public String getWordOfTheDay() {
    return wordOfTheDay;
  }

  public void setWordOfTheDay(String wordOfTheDay) {
    this.wordOfTheDay = wordOfTheDay;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
