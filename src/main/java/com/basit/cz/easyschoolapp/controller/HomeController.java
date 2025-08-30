package com.basit.cz.easyschoolapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class HomeController {

    @GetMapping({"","/","/home"})
    public String home() {
        return "home";
    }

}
