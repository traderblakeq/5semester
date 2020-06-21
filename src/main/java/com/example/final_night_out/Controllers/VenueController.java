package com.example.final_night_out.Controllers;

import com.example.final_night_out.Models.Features;
import com.example.final_night_out.Models.Pictures;
import com.example.final_night_out.Models.Venue;
import com.example.final_night_out.Services.IVenueService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.concurrent.ExecutionException;

@Log
@Controller
@SessionAttributes("venue")
public class VenueController {

    @Autowired
    private IVenueService iVenueService;

    private final String INDEX = "index";
    private final String EDIT_OPENING_HOURS = "editopeninghours";
    private final String REDIRECT_INDEX = "redirect:/index";
    private final String FEATURES_GET = "features";


    @GetMapping("index")
    public String index(@ModelAttribute("venue") Venue venue,
                        Model model) throws ExecutionException, InterruptedException
    {
        log.info("index action called...");

        model.addAttribute("venueData", iVenueService.findVenueByUid(venue.getUid()));
        model.addAttribute("news", iVenueService.fetchnews());
        model.addAttribute("pics", iVenueService.fetchPictures(venue.getUid()));

        log.info("index action ended...");

        return INDEX;
    }

    @GetMapping("/features")
    public String features(@ModelAttribute("venue") Venue venue,
                           Features features,
                           Model model) throws InterruptedException, ExecutionException
    {
        log.info("features action called...");

        Features fea = iVenueService.findFeatuesByUid(venue.getEmail());

        //initiate Feature Object for update purpose
        model.addAttribute("fea", fea);
        model.addAttribute("email", fea.getEmail());
        model.addAttribute("agelimit", fea.getAgeLimit());
        model.addAttribute("lgtb", fea.isLGTB());
        model.addAttribute("type", fea.getType());
        model.addAttribute("typeofvenue", fea.getTypeOfVenue());
        model.addAttribute("activities", fea.getActivities());
        model.addAttribute("smoking", fea.getSmoking());
        model.addAttribute("facilityType", fea.getFacilityType());
        model.addAttribute("soundStyle", fea.getSoundStyle());
        model.addAttribute("musicStyle", fea.getMusicStyle());
        model.addAttribute("beverage", fea.getBeverage());
        model.addAttribute("foodOptions", fea.getFoodOptions());
        model.addAttribute("dressCode", fea.getDressCode());

        log.info("features action ended...");

        return FEATURES_GET;
    }

    @PostMapping("/featuresPost")
    public String featuresPost(@ModelAttribute Features features,
                               @ModelAttribute("venue") Venue venue)throws InterruptedException, ExecutionException{

        log.info("featuresPost action called...");

        features.setEmail(venue.getEmail());
        iVenueService.updateFeatures(features);

        log.info("featuresPost action ended...");


        return REDIRECT_INDEX;
    }

    @GetMapping("/editopeninghours/{uid}")
    public String editopeninghours(@PathVariable("uid") String uid,
                                   Model model) throws InterruptedException, ExecutionException
    {
        log.info("editopeninghours action called...");

        model.addAttribute("venue", iVenueService.findVenueByUid(uid));

        log.info("editopeninghours action ended...");

        return EDIT_OPENING_HOURS;
    }

    @PostMapping("/editopeninghours")
    public String editopeninghoursSubmit(@ModelAttribute Venue venue,
                                         RedirectAttributes ra) {

        log.info("editopeninghoursSubmit action called...");

        iVenueService.updateOpeningHours(venue);
        ra.addFlashAttribute("venue", venue);

        log.info("editopeninghoursSubmit action ended...");

        return REDIRECT_INDEX;
    }

    @PostMapping("/uploadproductimage")
    public String uploadproductimage(@RequestParam("fileName") MultipartFile imageFile,
                               @ModelAttribute Pictures pictures,
                               @ModelAttribute("venue") Venue venue) throws Exception {

        log.info("uploadproductimage action called...");


        if(!imageFile.isEmpty())
        {
            iVenueService.savePics(venue.getUid(), pictures, imageFile);
        }

        log.info("uploadproductimage action ended...");


        return REDIRECT_INDEX;
    }

    @GetMapping("/deletepic")
    public String deletePic(@ModelAttribute("venue") Venue venue){

        log.info("deletepic action started");

        try{

            iVenueService.deletePics(venue.getUid());

        }catch (Exception e){
            log.info(String.valueOf(e));
        }

        log.info("delete pics action ended");

        return REDIRECT_INDEX;

    }
}
