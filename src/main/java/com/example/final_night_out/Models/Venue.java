package com.example.final_night_out.Models;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;


@Data
@Component
public class Venue {

    @DocumentId
    private String uid;

    private boolean admin = false;
    private String name;
    private String email;

    @Type(type="text")
    private String profilepicture; //TODO
    @Type(type="text")
    private String profileText; //TODO

    private String streetName;
    private String streetNumber;
    private String city;
    private String postalCode;
    private String phoneNumber;
    private String password;

    private String monday;
    private String mondayClose;
    private String thuesday;
    private String thuesdayClose;
    private String wednesday;
    private String wednesdayClose;
    private String thursday;
    private String thursdayClose;
    private String friday;
    private String fridayClose;
    private String saturday;
    private String saturdayClose;
    private String sunday;
    private String sundayClose;
}
