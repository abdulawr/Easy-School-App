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

@Service
public class ContactService {

    Log log = LogFactory.getLog(ContactService.class);
    @Autowired
    ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact) {
        contact.setStatus(SchoolConstant.Open);
        contact.setCreatedBy(SchoolConstant.Anonymous);
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.saveContactMsg(contact) > 0;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(SchoolConstant.Open);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId,SchoolConstant.Close, updatedBy);
        if(result>0) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
