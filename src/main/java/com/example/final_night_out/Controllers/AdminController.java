package com.example.final_night_out.Controllers;

import com.example.final_night_out.Models.Features;
import com.example.final_night_out.Models.Venue;
import com.example.final_night_out.Services.IAdminService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.ExecutionException;

@Log
@Controller
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    private final String ADMIN = "admin";
    private final String REDIRECT_ADMIN = "admin";


    @GetMapping("/admin")
    public String admin_get(Model model){

        log.info("admin_get action called...");

        model.addAttribute("venue", new Venue());

        log.info("admin_get action ended...");

        return ADMIN;
    }

    @PostMapping("/admin")
    public String admin_post(@ModelAttribute Venue venue,
                             Features features) throws ExecutionException, InterruptedException{

        log.info("admin_post action called...");

        features.setEmail(venue.getEmail());

        iAdminService.initialCreationVenue(venue);

        iAdminService.initialCreationFeatures(features);

        log.info("admin_post action ended...");

        return REDIRECT_ADMIN;
    }

}
