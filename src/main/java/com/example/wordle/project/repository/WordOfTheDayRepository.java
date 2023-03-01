package com.example.wordle.project.repository;

import com.example.wordle.project.model.WordOfTheDay;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.WatchEvent;
import java.time.LocalDate;

/**
 * Word of the day repository class.
 */
@Repository
public interface WordOfTheDayRepository extends MongoRepository<WordOfTheDay, String> {
    WordOfTheDay findWordOfTheDayByDate(LocalDate wordOfTheDay);
}
