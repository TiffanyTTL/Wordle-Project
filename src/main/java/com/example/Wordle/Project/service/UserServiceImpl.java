package com.example.Wordle.Project.service;

import com.example.Wordle.Project.model.User;
import com.example.Wordle.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service class.
 */
@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;


    /**
     * constructor generated for the user service class.
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * create user method class.
     */
    public  String createUser(User user) {
        userRepository.insert(user);
        return "user has been created";

    }
}
