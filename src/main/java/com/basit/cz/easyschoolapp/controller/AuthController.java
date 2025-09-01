package com.basit.cz.easyschoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @RequestMapping(value = "/login",method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@RequestParam(value = "error",required = false) String error,
                        @RequestParam(value = "logout",required = false) String logout, Model model) {
        String errorMsg = "";
        if (error != null) {
            errorMsg = "Username or Password is incorrect !!";
        }
        if (logout != null) {
            errorMsg = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMsg);
        return "login";
    }
}
