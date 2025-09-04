package com.basit.cz.easyschoolapp.service;

import com.basit.cz.easyschoolapp.constant.SchoolConstant;
import com.basit.cz.easyschoolapp.controller.ContactController;
import com.basit.cz.easyschoolapp.model.Contact;
import com.basit.cz.easyschoolapp.repository.ContactRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    Log log = LogFactory.getLog(ContactService.class);
    @Autowired
    ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact) {
        contact.setStatus(SchoolConstant.Open);
        Contact newContact =  contactRepository.save(contact);
        return newContact.getContactId() > 0;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(SchoolConstant.Open);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(SchoolConstant.Close);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
