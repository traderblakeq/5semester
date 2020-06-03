package com.example.final_night_out.Services;


import com.example.final_night_out.Models.Features;
import com.example.final_night_out.Models.Venue;
import com.example.final_night_out.Repositories.IFirebase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;

@Service
public class AdminService implements IAdminService{

    @Autowired
    private IFirebase firebaseRepo;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Venue initialCreationVenue(Venue venue) {

        venue.setPassword(passwordEncoder.encode(venue.getPassword()));

        return firebaseRepo.saveInitialCreationVenue(venue);
    }

    @Override
    public Features initialCreationFeatures(Features features)throws InterruptedException, ExecutionException {
        return firebaseRepo.saveFeatures(features.getEmail(), features);
    }
}
