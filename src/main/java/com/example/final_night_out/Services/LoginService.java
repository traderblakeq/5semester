package com.example.final_night_out.Services;

import com.example.final_night_out.Models.Venue;
import com.example.final_night_out.Repositories.FirebaseRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;

@Log
@Service
public class LoginService {

    @Autowired
    private FirebaseRepo firebaseRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Venue verifyVenue(String email, String password) throws InterruptedException, ExecutionException {

        Venue tmpVenue = firebaseRepo.fetchVenueForLogin(email, password);

        if(tmpVenue != null && passwordEncoder.matches(password, tmpVenue.getPassword())) {
            return tmpVenue;

        } else
            log.info("No venue were returned from Repo -- (LoginServicee.java)");
            return null;
    }
}
