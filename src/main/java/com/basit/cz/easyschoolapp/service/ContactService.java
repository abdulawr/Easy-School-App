package com.basit.cz.easyschoolapp.service;

import com.basit.cz.easyschoolapp.controller.ContactController;
import com.basit.cz.easyschoolapp.model.Contact;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    Log log = LogFactory.getLog(ContactService.class);

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
//        TODO: I will later add logic for saving data into DB
        System.out.println(contact.toString());
        return isSaved;
    }
}
