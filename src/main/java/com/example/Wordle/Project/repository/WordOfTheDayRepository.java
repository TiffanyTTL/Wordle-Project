package com.example.Wordle.Project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Word of the day repository class.
 */
@Repository
public interface WordOfTheDayRepository extends MongoRepository<WordOfTheDayRepository, String> {
}
