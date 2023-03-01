package com.example.wordle.project.controller;

import com.example.wordle.project.model.WordOfTheDay;
import com.example.wordle.project.requestbody.WordOfTheDayRequestBody;
import com.example.wordle.project.service.WordService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Word Controller class.
 */
@Slf4j
@RestController
@Log4j2
@CrossOrigin
@RequestMapping("/word")
public class WordController {

  private final WordService wordService;


  public WordController(WordService wordService) {
    this.wordService = wordService;
  }

  Logger logger = LoggerFactory.getLogger(WordController.class);
  /**
   * Post request method to create wordOfTheDay of the day.
   */
  @PostMapping("/createWordOfTheDay")
  @ResponseStatus(HttpStatus.CREATED)
  public WordOfTheDay createWordOfTheDay(@RequestBody WordOfTheDay wordOfTheDay) {
   logger.info("Word created");
    return wordService.createWord(wordOfTheDay);
  }

  /**
   * Get request method to get the wordOfTheDay of the day.
   */
  @GetMapping("/wordOfTheDay/{date}")
  @ResponseStatus(HttpStatus.OK)
  public WordOfTheDay getWordOfTheDayByDate(@PathVariable LocalDate date){
    logger.info(("Word of the day returned"));
    return wordService.getWordOfTheDayByDate(date);
  }

}
