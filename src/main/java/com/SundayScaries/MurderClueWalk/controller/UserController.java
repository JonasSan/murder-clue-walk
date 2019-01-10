package com.SundayScaries.MurderClueWalk.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


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

    @GetMapping("/game")
    public String gameview() {
        return "game";
    }

    @GetMapping("/profile")
    public String profileview() {
        return "profile";
    }


}
