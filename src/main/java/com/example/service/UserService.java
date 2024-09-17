package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User InsertUser(UserRequest userRequest){
        User user = new User(userRequest);
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
