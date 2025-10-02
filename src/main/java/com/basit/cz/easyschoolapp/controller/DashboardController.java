package com.basit.cz.easyschoolapp.controller;

import com.basit.cz.easyschoolapp.model.Person;
import com.basit.cz.easyschoolapp.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

   @Autowired
   PersonRepository personRepository;


   @RequestMapping("/dashboard")
   public String displayDashboard(Model model,Authentication authentication, HttpSession session) {
      Person person = personRepository.readByEmail(authentication.getName());
      model.addAttribute("username", person.getName());
      model.addAttribute("roles", authentication.getAuthorities().toString());
      session.setAttribute("loggedInPerson", person);
      return "dashboard.html";
   }
}
