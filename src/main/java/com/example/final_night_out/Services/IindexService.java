package com.example.final_night_out.Services;

import com.example.final_night_out.Models.Venue;

import java.util.concurrent.ExecutionException;

public interface IindexService {

    Venue getSpecificVenue(String venueName)throws InterruptedException, ExecutionException;

    Venue initialCreationVenue(String name,
                               String email,
                               String streetName,
                               String streetNumber,
                               String city,
                               String postalcode,
                               String phoneNumber,
                               String password
    );
    /*
    Venue setOpeningHours(
                            String uid,
                            String monday,
                            String thuesday,
                            String wednesday,
                            String thursday,
                            String friday,
                            String saturday,
                            String sunday
    );

    Venue findVenueByUid(String uid) throws InterruptedException, ExecutionException;


    Venue updateOpeningHours(String uid,
                             String monday,
                             String thuesday,
                             String wednesday,
                             String thursday,
                             String friday,
                             String saturday,
                             String sunday);*/

}
