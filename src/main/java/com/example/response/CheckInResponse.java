package com.example.response;

import com.example.entity.CheckIn;
import com.example.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class CheckInResponse {

    private long id;

    private int locationId;

    private Date checkInDate;

    private List<User> users = new ArrayList<User>();

    public CheckInResponse( CheckIn checkIn){
        this.locationId = checkIn.getLocationId();
        this.checkInDate = checkIn.getCheckInDate();
        this.id = checkIn.getId();
        //for(int i = 0; i < checkIn.getUsers().size(); i++){ this.users.add(checkIn.getUsers().get(i)); }
        checkIn.getUsers().stream().forEach(user -> this.users.add(user));

    }
}
