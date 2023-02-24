package com.example.Wordle.Project.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Word of the day model class.
 */
@Document("Word of the day")
public class WordOfTheDay {
  @Id
  @Indexed(unique = true)
  public String userId;
  @Field(name = "word")
  public String wordOfTheDay;
  @Field(name = "date")
  public LocalDate date;

  public WordOfTheDay() {

  }
}
