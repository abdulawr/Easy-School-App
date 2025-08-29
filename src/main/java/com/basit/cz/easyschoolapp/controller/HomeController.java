package com.basit.cz.easyschoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping({"","/","/home"})
    public String home(Model model) {
        model.addAttribute("country", List.of("Pakistan","India","Japan","China"));
        return "home";
    }

}
