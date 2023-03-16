package com.example.wordle.project.service;

import com.example.wordle.project.model.Game;
import com.example.wordle.project.model.WordOfTheDay;
import com.example.wordle.project.repository.UserRepository;
import com.example.wordle.project.repository.WordOfTheDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Word service class.
 */
@Service
public class WordService {

  @Autowired
  private WordOfTheDayRepository wordOfTheDayRepository;

  @Autowired
  UserRepository userRepository;

  Game game;

  /**
   * constructor generated for the user service class.
   */
  public WordService(WordOfTheDayRepository wordOfTheDayRepository) {
    this.wordOfTheDayRepository = wordOfTheDayRepository;
  }

  /**
   * create wordOfTheDay method class.
   */
  public WordOfTheDay createWord(WordOfTheDay wordOfTheDay) {
    WordOfTheDay wordsToday = new WordOfTheDay();
    wordsToday.setWordOfTheDay(wordOfTheDay.getWordOfTheDay());
    wordsToday.setDate(LocalDate.parse(wordOfTheDay.getDate().toString()));
    wordOfTheDayRepository.insert(wordsToday);
    return wordOfTheDay;
  }

  public WordOfTheDay getWordOfTheDayByDate(LocalDate wordOfTheDay) {
   return wordOfTheDayRepository.findWordOfTheDayByDate(wordOfTheDay);
  }

}
