package com.example.wordle.project.repository;

import com.example.wordle.project.model.GameResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository class.
 */
@Repository
public interface GamesResponseRepo extends MongoRepository<GameResponse, String> {

    GameResponse findGameResponseByWordGuess(String wordGuess);
}
