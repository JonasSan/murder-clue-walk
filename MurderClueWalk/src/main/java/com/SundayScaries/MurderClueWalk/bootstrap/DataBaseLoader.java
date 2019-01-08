package com.SundayScaries.MurderClueWalk.bootstrap;

import com.SundayScaries.MurderClueWalk.domain.*;
import com.SundayScaries.MurderClueWalk.domain.User;

import com.SundayScaries.MurderClueWalk.repository.UserRepository;
import com.SundayScaries.MurderClueWalk.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements CommandLineRunner {

    UserService userService;
    UserRepository userRepository;


    public DataBaseLoader(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        String pw = BCrypt.hashpw("admin123", BCrypt.gensalt());

        User user1 = new User("random@email.com", pw, 10.15, 20, "male", "sweden");
        UserService.save(user1);
        System.out.println(user1.toString());

    }
}