package com.basit.cz.easyschoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.basit.cz.easyschoolapp.repository")
@EntityScan("com.basit.cz.easyschoolapp.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class StartUpApp {

    public static void main(String[] args) {
        SpringApplication.run(StartUpApp.class, args);
    }

}
