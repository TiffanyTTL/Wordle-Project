package com.example.wordle.project.repository;

import com.example.wordle.project.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {

   Game findGameByUserEmailAddress (String userEmailAddress);
}
