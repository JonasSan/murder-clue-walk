package com.SundayScaries.MurderClueWalk.service;

import com.SundayScaries.MurderClueWalk.domain.User;
import com.SundayScaries.MurderClueWalk.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public static User save(User user) {
        userRepository.save(user);
        return user;
    }


    public void deleteById(Integer id) {
        userRepository.deleteById(id);

    }


    public User findByEmail(String loginName) {
        Optional<User> optionalUser = userRepository.findByLoginName(loginName);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }


}
