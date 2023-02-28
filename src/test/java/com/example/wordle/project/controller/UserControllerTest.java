package com.example.wordle.project.controller;

import com.example.wordle.project.model.User;
import com.example.wordle.project.repository.UserRepository;
import com.example.wordle.project.service.UserService;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Mock
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @InjectMocks
    UserController userController;

    @Mock
    private User user;

    @Mock
    private RequestAttributes attributes;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setUp() {
        RequestContextHolder.setRequestAttributes(attributes);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

    }

    @Test
    public void createUserTest() throws Exception {
        // given precondition
        User mockUser = new User();
        mockUser.setUserEmailAddress("tiffany@wordle.com");
        given(userService.createUser(Mockito.any())).willReturn(new User("tiffany@wordle.com"));
        //action I will be testing
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/user/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockUser))
                        .accept(MediaType.APPLICATION_JSON))
                //verify the result
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userEmailAddress").value("tiffany@wordle.com"));

    }


}





