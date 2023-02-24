package com.example.Wordle.Project.controller;

import com.example.Wordle.Project.model.GameResponse;
import com.example.Wordle.Project.model.User;
import com.example.Wordle.Project.repository.UserRepository;
import com.example.Wordle.Project.requestbody.GameResponseRequestBody;
import com.example.Wordle.Project.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    User user;

    @Mock
    UserController userController;

    @Mock
    RequestAttributes attributes;

    @BeforeEach
    public void setUp() {
        RequestContextHolder.setRequestAttributes(attributes);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

    }

    @Test
    public void createUserTest() throws Exception {
        User userDetails = new User();
        user.setUserEmailAddress("tiffany@wordle.com");
        Mockito.when(userRepository.save(userDetails)).thenReturn(userDetails);
        mockMvc.perform(post("/user/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

    }

    @Test
    @DisplayName("Test Should Pass If Guess Has Been Submitted")
    public void submitGuess_successTest() throws Exception {
        GameResponseRequestBody gameResponse = new GameResponseRequestBody();
        gameResponse.setUserEmailAddress("libby@lib.com");
        gameResponse.setCurrentTries(2);
        gameResponse.setWordGuess("APPLE");
        gameResponse.setWordStatus("PRESENT_BUT_MISPLACED");
        gameResponse.setGameStatus("IN_PROGRESS");
        Mockito.when(userService.submitGuess(gameResponse)).thenReturn();
        MvcResult result = (MvcResult) mockMvc.perform(post("/user/submitGuess")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertNotNull(content);
        assertEquals(, userService.submitGuess(gameResponse));
        System.out.println(content);


    }
}


