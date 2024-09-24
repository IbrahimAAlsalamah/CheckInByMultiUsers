package com.example.controller;

import com.example.entity.CheckIn;
import com.example.exceptions.lessThanTwoException;
import com.example.request.CheckInRequest;
import com.example.response.CheckInResponse;
import com.example.service.CheckInService;
import jakarta.validation.UnexpectedTypeException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/checkIn/")
public class CheckInController {

    @Autowired
    CheckInService checkInService;

    @PostMapping("insert/{userId}")
    public CheckInResponse InsertCheckIn(
            @Valid @RequestBody CheckInRequest checkInRequest,
            @PathVariable Long userId
    ){
        CheckInResponse checkInResponse = new CheckInResponse(
                checkInService.InsertCheckIn(checkInRequest,userId));
        return checkInResponse;
    }

    @GetMapping("getAll")
    public List<CheckInResponse> getAllCheckIn(){
        List<CheckIn> checkIns = checkInService.getAllCheckIns();
        List<CheckInResponse> checkInResponses = new ArrayList<>();

        checkIns.stream().forEach(CheckIn -> {
            checkInResponses.add(new CheckInResponse(CheckIn));
        });

        return checkInResponses;
    }
    @PutMapping("checkinByUsers")
    public CheckInResponse checkInWithUsers(
            @RequestParam List<Long> usersId,
            @Valid @RequestBody CheckInRequest checkInRequest
    ) {
        if(usersId.size()<=1) throw new lessThanTwoException();
        CheckInResponse checkInResponse = new CheckInResponse(
                checkInService.checkInWithUsers(usersId, checkInRequest));
        return checkInResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public String CanNotFoundUserException(NoSuchElementException e) {
        return "Can not found the user";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(lessThanTwoException.class)
    public String CanNotFoundUserException(lessThanTwoException e) {
        return e.getMessage();
    }

}
