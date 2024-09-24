package com.example.exceptions;

import lombok.Getter;

@Getter
public class lessThanTwoException extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    public lessThanTwoException(){
        super("Users should be more than one");
    }
}

