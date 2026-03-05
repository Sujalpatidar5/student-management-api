package com.cfs.student_api.service;

import com.cfs.student_api.entity.User;
import com.cfs.student_api.repo.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {           //****** DB user ko spring format me convert krna
     // UserDetailsService - mtlb meh spring security ko db se user laake dunga
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //db se user lao
        User dbUser = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        //ye ek spring security ka UserDetails object bna k return kr raha h
        return org.springframework.security.core.userdetails.User
                .withUsername(dbUser.getUsername())
                .password(dbUser.getPassword())
                .roles(dbUser.getRole())
                .build();   //ye  object bna deta h
    }
}
