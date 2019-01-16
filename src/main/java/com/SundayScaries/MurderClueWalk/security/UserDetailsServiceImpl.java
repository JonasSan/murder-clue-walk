package com.SundayScaries.MurderClueWalk.security;

import com.SundayScaries.MurderClueWalk.domain.User;
import com.SundayScaries.MurderClueWalk.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLoginName(loginName);
        if (!user.isPresent()){
            throw new UsernameNotFoundException(loginName);
        }
        return user.get();
    }
}