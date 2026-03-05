package com.cfs.student_api.config;

import com.cfs.student_api.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig (CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //password ko encrypt krne k liye
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();            //BCrypt algorithm use krega pw encrypt krne k liye
    }

    //security rules
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated())
                        .httpBasic(Customizer.withDefaults());

        return http.build();

    }
}
