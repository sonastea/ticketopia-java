package com.sonastea.Ticketopia.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("name", userDetails.getUsername());
        return "greeting";
    }

}