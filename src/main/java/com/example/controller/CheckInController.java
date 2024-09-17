package com.example.controller;

import com.example.entity.CheckIn;
import com.example.request.CheckInRequest;
import com.example.response.CheckInResponse;
import com.example.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/checkIn/")
public class CheckInController {

    @Autowired
    CheckInService checkInService;

    @PostMapping("insert/{userId}")
    public CheckInResponse InsertCheckIn(
            @Validated @RequestBody CheckInRequest checkInRequest,
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
            @Validated @RequestBody CheckInRequest checkInRequest
    ) {
        CheckInResponse checkInResponse = new CheckInResponse(
                checkInService.checkInWithUsers(usersId, checkInRequest));
        return checkInResponse;
    }

}
