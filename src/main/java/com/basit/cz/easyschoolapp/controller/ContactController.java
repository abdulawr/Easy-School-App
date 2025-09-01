package com.basit.cz.easyschoolapp.controller;

import com.basit.cz.easyschoolapp.model.Contact;
import com.basit.cz.easyschoolapp.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ContactController {

    @Autowired
    ContactService contactService;


    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/saveMsg")
    public String saveMsg(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            log.info("Errors found in contact form => "+errors.toString());
            return "contact.html";
        }

       contactService.saveMessageDetails(contact);
       return "redirect:/contact";
    }
}

