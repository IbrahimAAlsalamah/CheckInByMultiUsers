package com.example.controller;

import com.example.entity.User;
import com.example.request.UserRequest;
import com.example.response.UserResponse;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("insert")
    public UserResponse InsertUser(@Validated @RequestBody UserRequest userRequest){
        UserResponse userResponse = new UserResponse(
                userService.InsertUser(userRequest));

        return userResponse;
    }

    @GetMapping("getAll")
    public List<UserResponse> getAllUsers(){
        List<User> users = userService.getAllUsers();
        List<UserResponse> userResponses = new ArrayList<>();

        users.stream().forEach(User -> {
            userResponses.add(new UserResponse(User));
        });

        return userResponses;
    }


}
