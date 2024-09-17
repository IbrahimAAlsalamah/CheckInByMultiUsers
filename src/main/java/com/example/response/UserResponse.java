package com.example.response;

import com.example.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {

    private long id;

    private String name;

    public UserResponse(User user) {
        this.name = user.getName();
        this.id = user.getId();
    }
}
