package com.SundayScaries.MurderClueWalk.controller;

import com.SundayScaries.MurderClueWalk.domain.User;
import com.SundayScaries.MurderClueWalk.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register/submit")
    public String createUser(RedirectAttributes redirectAttributes, @RequestParam String loginName, @RequestParam String password, @RequestParam String gender, @RequestParam int age, @RequestParam String country){
        System.out.println("vi är här!");
        User user10 = new User(loginName, password, gender, age, country);
        userRepository.save(user10);
        logger.info("Ny användare registrerad");
        redirectAttributes
                .addAttribute(user10)
                .addFlashAttribute("success", true);
        return "profile";
    }




}