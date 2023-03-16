package com.example.wordle.project.repository;

import com.example.wordle.project.model.GameHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * User repository class.
 */
@Repository
public interface GameHistoryRepository extends MongoRepository<GameHistory, String> {

   GameHistory findGameHistoriesByUserEmailAddress (String userEmailAddress);

}
