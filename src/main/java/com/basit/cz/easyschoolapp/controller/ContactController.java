package com.basit.cz.easyschoolapp.controller;

import com.basit.cz.easyschoolapp.model.Contact;
import com.basit.cz.easyschoolapp.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;


    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("saveMsg")
    public ModelAndView saveMsg(@ModelAttribute Contact contact) {
       contactService.saveMessageDetails(contact);
       return new ModelAndView("redirect:/contact");
    }
}

