package com.example.final_night_out.Controllers;

import com.example.final_night_out.Models.Venue;
import com.example.final_night_out.Services.LoginService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.ExecutionException;

@Log
@Controller
@SessionAttributes("venue")
public class LoginController {

    private final String LOGIN_FORM = "login_form";
    private final String ADMIN = "admin";
    private final String REDIRECT_INDEX = "redirect:/index";
    private final String REDIRECT = "redirect:";

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String showLoginForm()
    {
        return LOGIN_FORM;
    }

    @PostMapping("/")
    public String verifyLogin(@RequestParam String email,
                              @RequestParam String password,
                              ModelMap model,
                              Venue venue,
                              RedirectAttributes ra){

        log.info("login action called...");

        try {
            venue = loginService.verifyVenue(email, password);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (venue == null) {

            model.addAttribute("loginError", "Error logging in, Please try again");

            return REDIRECT;

        } else if (venue != null & !venue.isAdmin()) {

            log.info("login successful  - action ended ...");

            model.put("venue", venue);

            //ra.addFlashAttribute("venue", venue);

            return REDIRECT_INDEX;

        } else if (venue !=null & venue.isAdmin()) {

            model.addAttribute("venue", new Venue());

            log.info("admin login");

            return ADMIN;
        }

        log.info("login action ended...");

        return null;
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status){

        log.info("logout action started");

        status.setComplete();

        log.info("logout action ended");

        return LOGIN_FORM;
    }
}
