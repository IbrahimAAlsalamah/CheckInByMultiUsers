package com.example.service;

import com.example.entity.CheckIn;
import com.example.entity.User;
import com.example.repository.CheckInRepository;
import com.example.repository.UserRepository;
import com.example.request.CheckInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckInService {

    @Autowired
    CheckInRepository checkInRepository;

    @Autowired
    UserRepository userRepository;

    public CheckIn InsertCheckIn(CheckInRequest checkInRequest,Long userId){

        CheckIn checkIn = new CheckIn(checkInRequest);
        User user = userRepository.findById(userId).get();
        checkIn.getUsers().add(user);
        checkInRepository.save(checkIn);

        return checkIn;
    }

    public List<CheckIn> getAllCheckIns(){
        return checkInRepository.findAll();
    }

    public CheckIn checkInWithUsers(List<Long> usersId, CheckInRequest checkInRequest) {

        CheckIn checkIn = new CheckIn(checkInRequest);

        usersId.stream().forEach(userId -> {
            User user = userRepository.findById(userId).get();
            checkIn.getUsers().add(user);
        });

        checkInRepository.save(checkIn);
        return checkIn;




    }
}
