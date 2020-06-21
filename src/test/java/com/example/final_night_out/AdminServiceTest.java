package com.example.final_night_out;


import com.example.final_night_out.Models.Features;
import com.example.final_night_out.Models.Venue;
import com.example.final_night_out.Repositories.IFirebase;
import com.example.final_night_out.Services.AdminService;
import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Log
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AdminServiceTest {

    @Autowired
    @InjectMocks
    private AdminService adminService;

    @Mock
    private IFirebase firebase;

    @Autowired
    public PasswordEncoder passwordEncoder;

    private Venue venue;
    private Features features;

    @BeforeEach
    void init(){
        venue = new Venue();
        venue.setEmail("Test@test.dk");
        venue.setPassword("123456");

        features = new Features();
        features.setEmail("test@test.com");

        MockitoAnnotations.initMocks(this);
    }


    @Test
    void saveInitialVenueWhenCallingService() {

        log.info("saveInitialVenueWhenCallingService test is executed");

        //Given
        when(firebase.saveInitialCreationVenue(venue)).thenReturn(venue);

        //When
        Venue returnedVenue = adminService.initialCreationVenue(venue);

        //Hash password on test obj
        venue.setPassword(passwordEncoder.encode(venue.getPassword()));

        //Then assert that password has been hashed on both obj's
        assertEquals(venue, returnedVenue);
    }

    @Test
    void saveInitialCreationFeaturesWhenCallingService()throws InterruptedException, ExecutionException {

        log.info("saveInitialCreationFeaturesWhenCallingService test is executed");

        //Given
        when(firebase.saveFeatures(features.getEmail(),features)).thenReturn(features);

        //When
        Features returnedFeature = adminService.initialCreationFeatures(features);

        //Then
        assertEquals(features, returnedFeature);
    }
}
