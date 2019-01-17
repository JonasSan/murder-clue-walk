package com.SundayScaries.MurderClueWalk.controller;

import com.SundayScaries.MurderClueWalk.domain.User;
import com.SundayScaries.MurderClueWalk.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


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
        User user10 = new User(loginName, password, gender, age, country);
        userRepository.save(user10);
        logger.info("Ny användare registrerad");
        redirectAttributes
                .addAttribute(user10)
                .addFlashAttribute("success", true);
        return "redirect:/profile";
    }


////Hämtat, måste anpassa för att få ihop inloggning.
//    @PostMapping("/index")
//    public String loginUser(@RequestParam String loginName, @RequestParam String password, RedirectAttributes redirectAttributes, Model model){
//        List<User> users = userRepository.findAll();
//        System.out.println("1");
//        for (User currentUser: users) {
//
//            if (loginName.equals(currentUser.getLoginName()) && password.equals(currentUser.getPassword())){
//                System.out.println("2");
//                String loginSuccess = "Välkommen, "+currentUser.getLoginName();
//                redirectAttributes.addFlashAttribute(loginSuccess);
//                System.out.println("Inloggning lyckad");
//            }
//        }
//        System.out.println("3");
//        String loginFail = "Fel användarnamn och/eller lösenord";
//        redirectAttributes.addFlashAttribute(loginFail);
//        System.out.println("Inloggning misslyckad");
//        return "redirect:/profile";
//    }

//    @GetMapping("/index/findAllUsers")
//    public List<User> findAllUsers() {
//        List<User> findAllUsers = userRepository.findAll();
//        return findAllUsers;
//    }


    @GetMapping("/profiles")
    public String listUsers(Model model) {
        System.out.println("Vi är här 1");
        Optional<User> user = userRepository.findById(4);
        System.out.println(user);
        model.addAttribute("user", user.get());
        return "profile";
    }


}