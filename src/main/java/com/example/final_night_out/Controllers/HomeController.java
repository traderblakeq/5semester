package com.example.final_night_out.Controllers;

import com.example.final_night_out.Services.IindexService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Log
@Controller
public class HomeController {

    private final String INDEX = "index";
    private final String EDIT_OPENING_HOURS = "editopeninghours";
    private final String REDIRECT_INDEX = "redirect:/index";


    @Autowired
    private IindexService indexService;

    /*
    @PostMapping("/admin")
    public String admin_post(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("streetName") String streetName,
                               @RequestParam("streetNumber") String streetNumber,
                               @RequestParam("city") String city,
                               @RequestParam("postalCode") String postalCode,
                               @RequestParam("phoneNumber") String phoneNumber,
                               @RequestParam("password") String password){

        indexService.initialCreationVenue(  name,
                                            email,
                                            streetName,
                                            streetNumber,
                                            city,
                                            postalCode,
                                            phoneNumber,
                                            password);

        return null;
    }


    @GetMapping("/index")
    public String index(@ModelAttribute("venue") Venue venue, Model model)
    {
        model.addAttribute("venueData", venue);

        return INDEX;
    }

    @GetMapping("/editopeninghours/{uid}")
    public String editopeninghours(@PathVariable("uid") String uid, Model model) throws InterruptedException, ExecutionException
    {

        model.addAttribute("venue", indexService.findVenueByUid(uid));

        return EDIT_OPENING_HOURS;
    }*/

    /*
    @PostMapping("/editopeninghours")
    public String editopeninghoursSubmit(@RequestParam("uid") String uid,
                                     @RequestParam("monday") String monday,
                                     @RequestParam("thuesday") String thuesday,
                                     @RequestParam("wednesday") String wednesday,
                                     @RequestParam("thursday") String thursday,
                                     @RequestParam("friday") String friday,
                                     @RequestParam("saturday") String saturday,
                                     @RequestParam("sunday") String sunday) {

        indexService.updateOpeningHours(uid,
                                        monday,
                                        thuesday,
                                        wednesday,
                                        thursday,
                                        friday,
                                        saturday,
                                        sunday);

        return REDIRECT_INDEX;
    }*/
}
