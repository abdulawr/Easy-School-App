package com.basit.cz.easyschoolapp.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class DashboardController {
   @GetMapping("/dashboard")
    public String displayDashboard(HttpSession session, Model model, Authentication auth) {
       model.addAttribute("username", auth.getName());
       model.addAttribute("roles", auth.getAuthorities().toString());
       return "dashboard";
   }
}
