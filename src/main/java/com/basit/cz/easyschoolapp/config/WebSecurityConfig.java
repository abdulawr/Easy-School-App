package com.basit.cz.easyschoolapp.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
           authorize.requestMatchers("/contact").permitAll()
                   .requestMatchers("/","/home").permitAll()
                   .requestMatchers("/courses").permitAll()
                   .requestMatchers("/saveMsg").permitAll()
                   .requestMatchers("/holidays/**").permitAll()
                   .requestMatchers("/about").permitAll()
                   .requestMatchers("/assets/**").permitAll()
                   .requestMatchers(PathRequest.toH2Console()).permitAll()
                   .requestMatchers("/dashboard").authenticated()
                   .requestMatchers("/displayMessages").authenticated()
                   .requestMatchers("/closeMsg").authenticated()
        ).formLogin(
                loginConfig ->
                        loginConfig.loginPage("/login")
                        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true")
                        .permitAll()
                ).logout(logoutConfig ->
                        logoutConfig.logoutSuccessUrl("/login?logout=true")
                                .invalidateHttpSession(true)
                                .permitAll()
                ).httpBasic(Customizer.withDefaults());

       http.headers(header -> header.disable());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("user")
                .password("12345")
                .roles("USER")
                .build();
        UserDetails admin = users
                .username("admin")
                .password("12345")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}
