package com.example.request;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserRequest {

    //@NotBlank(message = "First name is req")
    private String name;
}
