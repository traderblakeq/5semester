package com.example.final_night_out.Services;

import com.example.final_night_out.Models.Venue;
import com.example.final_night_out.Repositories.IFirebase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;

@Service
public class IndexService implements IindexService {

    @Autowired
    IFirebase firebaseRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Venue getSpecificVenue(String venueName)throws InterruptedException, ExecutionException{
            return firebaseRepo.fetchSpecificVenueDetails(venueName);
    }

    public Venue initialCreationVenue(String name,
                                      String email,
                                      String streetName,
                                      String streetNumber,
                                      String city,
                                      String postalCode,
                                      String phoneNumber,
                                      String password){

        Venue venue = new Venue();
        venue.setName(name);
        venue.setEmail(email);
        venue.setStreetName(streetName);
        venue.setStreetNumber(streetNumber);
        venue.setCity(city);
        venue.setPostalCode(postalCode);
        venue.setPhoneNumber(phoneNumber);
        venue.setPassword(passwordEncoder.encode(password));
        firebaseRepo.saveInitialCreationVenue(venue);

        return null;
    }

    /*
    @Override
    public Venue setOpeningHours(String uid,
                                 String monday,
                                 String thuesday,
                                 String wednesday,
                                 String thursday,
                                 String friday,
                                 String saturday,
                                 String sunday) {

        Venue venue = new Venue();
        venue.setUid(uid);
        venue.setMonday(monday);
        venue.setThuesday(thuesday);
        venue.setWednesday(wednesday);
        venue.setThursday(thursday);
        venue.setFriday(friday);
        venue.setSaturday(saturday);
        venue.setSunday(sunday);
        firebaseRepo.saveOpeningHours(venue);

        return null;
    }

    @Override
    public Venue findVenueByUid(String uid) throws InterruptedException, ExecutionException{
        return firebaseRepo.fetchVenueByUid(uid);
    }

    @Override
    public Venue updateOpeningHours(String uid, String monday, String thuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {

        Venue venue = new Venue();
        venue.setUid(uid);
        venue.setMonday(monday);
        venue.setThuesday(thuesday);
        venue.setWednesday(wednesday);
        venue.setThursday(thursday);
        venue.setFriday(friday);
        venue.setSaturday(saturday);
        venue.setSunday(sunday);

        return firebaseRepo.saveOpeningHours(venue);
    }*/
}
