package com.basit.cz.easyschoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncodeConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        // BCrypt with strength (log rounds) 10–14 is typical
        return new BCryptPasswordEncoder(12);
        // return new Pbkdf2PasswordEncoder();   // also good
        // return new Argon2PasswordEncoder();   // also good
    }
}
