package com.example.wordle.project.controller;

import com.example.wordle.project.model.*;
import com.example.wordle.project.repository.UserRepository;
import com.example.wordle.project.repository.WordOfTheDayRepository;
import com.example.wordle.project.requestbody.StartGameRequestBody;
import com.example.wordle.project.requestbody.SubmitGuessRequestBody;
import com.example.wordle.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static com.example.wordle.project.model.GameStatus.WIN;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    UserController userController;

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    WordOfTheDayRepository wordOfTheDayRepository;

    @Mock
    private User user;

    @Mock
    private Game game;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        //RequestContextHolder.setRequestAttributes(attributes);
        //this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        StartGameRequestBody startGameRequestBody = new StartGameRequestBody();
    }

    @BeforeTestMethod
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createUserTest() throws Exception {
        // given precondition
        User mockUser = new User();
        mockUser.setUserEmailAddress("tiffany@wordle.com");
        given(userService.createUser(Mockito.any())).willReturn(new User("tiffany@wordle.com"));
        //action I will be testing
        mockMvc.perform(post("/user/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockUser))
                        .accept(MediaType.APPLICATION_JSON))
                //verify the result
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userEmailAddress").value("tiffany@wordle.com"));

    }


    @Test
    public void addGameToDatabaseTest() throws Exception {
        // given precondition
        StartGameRequestBody startGameRequestBody = new StartGameRequestBody();
        startGameRequestBody.setUserEmailAddress("lucy@wordle.com");
        Mockito.when(userService.addGameToDatabase(startGameRequestBody)).thenReturn(user);
        String jsonBody = "{\"userEmailAddress\":\"lucy@wordle.com\"}";
        //action I will be testing
        MvcResult result = (MvcResult) mockMvc.perform(MockMvcRequestBuilders
                             .post("/user/startGame")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //verify the result
                .andDo(print())
                .andExpect(status().isCreated())
                     .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertNotNull(content);
        assertEquals(user,userService.addGameToDatabase(startGameRequestBody));
        System.out.println(content);



    }

    @Test
    public void submitGuess() throws Exception {
        // given precondition
        SubmitGuessRequestBody submitGuessRequestBody = new SubmitGuessRequestBody();
        submitGuessRequestBody.setGuessResponse("ANGER");
        submitGuessRequestBody.setDate(LocalDate.of(2023,3,5));
        submitGuessRequestBody.setUserEmailAddress("frances@wordle.com");
        Mockito.when(userService.submitGuess(submitGuessRequestBody)).thenReturn(new GameResponse());
        //action I will be testing
        MvcResult result = (MvcResult) mockMvc.perform(MockMvcRequestBuilders
                        .post("/user/submitGame")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //verify the result
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertNotNull(content);
        assertEquals(new GameResponse(),userService.submitGuess(submitGuessRequestBody));
        System.out.println(content);



    }
}

//    @Test
//    public void submitGuess_SuccessTest() throws Exception {
//        SubmitGuessRequestBody submitGuessRequestBody = new SubmitGuessRequestBody();
//        submitGuessRequestBody.setGuessResponse("Angry");
//        submitGuessRequestBody.setUserEmailAddress("Tom@wordle.com");
//        submitGuessRequestBody.setDate(LocalDate.of(2023,3,10));
//        Mockito
//
//    }


//    @Test
//    public void ifUserWordMatches_wordOfTheDayTest() {
//        SubmitGuessRequestBody submitGuessRequestBody = new SubmitGuessRequestBody();
//        submitGuessRequestBody.setGuessResponse("APPLE");
//        WordOfTheDay wordOfTheDay = new WordOfTheDay();
//        wordOfTheDay.setWordOfTheDay("APPLE");
//        //given(submitGuessRequestBody.getGuessResponse().matches(wordOfTheDay.getWordOfTheDay())).willReturn(WIN);
//    }
//
//
//}
//
