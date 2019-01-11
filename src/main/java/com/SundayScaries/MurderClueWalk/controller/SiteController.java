package com.SundayScaries.MurderClueWalk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SiteController {
    private static final Logger logger = LoggerFactory.getLogger(SiteController.class);

    @GetMapping("/register")
    public String registerview() {
        return "register";
    }

    @GetMapping("/index")
    public String homeview() {
        return "index";
    }

    @GetMapping("/about")
    public String aboutview() {
        return "about";
    }
    @GetMapping("/tutorial")
    public String tutorialview() {
        return "tutorial";
    }

    @GetMapping("/game")
    public String gameview() {
        return "game";
    }

    @GetMapping("/profile")
    public String profileview() {
        return "profile";
    }


}
