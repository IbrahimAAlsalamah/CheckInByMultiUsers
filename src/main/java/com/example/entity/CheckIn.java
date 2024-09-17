package com.example.entity;

import com.example.request.CheckInRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checkin")
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "check_in_id")
    private int id;

    @Column(name = "location_id")
    private int locationId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Column(name = "date")
    private Date checkInDate;

    @ManyToMany
    @JoinTable( name = "checkin_students",
            joinColumns = @JoinColumn(name = "check_in_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
            )
    private List<User> users = new ArrayList<User>();

    public CheckIn(CheckInRequest checkInRequest){

        this.locationId = checkInRequest.getLocationId();

    }
}
