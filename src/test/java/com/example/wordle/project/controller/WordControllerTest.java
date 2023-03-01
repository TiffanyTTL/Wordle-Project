package com.example.wordle.project.controller;

import com.example.wordle.project.model.User;
import com.example.wordle.project.model.WordOfTheDay;
import com.example.wordle.project.repository.UserRepository;
import com.example.wordle.project.repository.WordOfTheDayRepository;
import com.example.wordle.project.service.UserService;
import com.example.wordle.project.service.WordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    WordService wordService;


    @MockBean
    WordOfTheDayRepository wordOfTheDayRepository;

    @InjectMocks
    WordController wordController;

    @Mock
    private WordOfTheDay wordOfTheDay;

    @Mock
    private RequestAttributes attributes;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setUp() {
        RequestContextHolder.setRequestAttributes(attributes);
        this.mockMvc = MockMvcBuilders.standaloneSetup(wordController).build();

    }

    @Test
    public void createWordsForWordleGameTest() throws Exception {
        // given precondition
        WordOfTheDay mockWordOfTheDay = new WordOfTheDay();
        mockWordOfTheDay.setWord("MAGIC");
        mockWordOfTheDay.setDate(LocalDate.of(2023,2,28));
        given(wordService.createWord(Mockito.any())).willReturn(new WordOfTheDay("MAGIC", LocalDate.of(2023,2,28)));
        //action I will be testing
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/word/createWordOfTheDay")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockWordOfTheDay))
                        .accept(MediaType.APPLICATION_JSON))
                //verify the result
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.word").value("MAGIC"));

    }
}
