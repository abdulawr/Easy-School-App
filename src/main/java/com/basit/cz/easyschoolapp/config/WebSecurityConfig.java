package com.basit.cz.easyschoolapp.config;

import com.basit.cz.easyschoolapp.security.CustomUsernameAndPwdAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig {

    @Autowired
    CustomUsernameAndPwdAuth customUsernameAndPwdAuth;

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {

        http.csrf((csrf) ->
                        csrf.ignoringRequestMatchers("/saveMsg").
                                ignoringRequestMatchers("/public/**")
                                .ignoringRequestMatchers("/api/**")
                )
                .authorizeHttpRequests((requests) ->
                        requests.requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/displayMessages/**").hasRole("ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/closeMsg/**").hasRole("ADMIN")
                        .requestMatchers("/", "/home").permitAll()
                        .requestMatchers("/holidays/**").permitAll()
                        .requestMatchers("/actuator/**").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/displayProfile").permitAll()
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/updateProfile").authenticated()
                        .requestMatchers("/api/**").authenticated()
                )
                        .authenticationProvider(customUsernameAndPwdAuth)
                .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
                .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID").permitAll())
                .httpBasic(Customizer.withDefaults());

       //http.headers(header -> header.disable());
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        UserDetails user = users
//                .username("user")
//                .password("12345")
//                .roles("USER")
//                .build();
//        UserDetails admin = users
//                .username("admin")
//                .password("12345")
//                .roles("USER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

}
