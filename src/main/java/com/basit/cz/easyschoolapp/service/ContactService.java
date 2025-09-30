package com.basit.cz.easyschoolapp.service;

import com.basit.cz.easyschoolapp.constant.SchoolConstant;
import com.basit.cz.easyschoolapp.controller.ContactController;
import com.basit.cz.easyschoolapp.model.Contact;
import com.basit.cz.easyschoolapp.repository.ContactRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        contact.setStatus(SchoolConstant.OPEN);
        Contact newContact =  contactRepository.save(contact);
        return newContact.getContactId() > 0;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus(
                SchoolConstant.OPEN,pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(SchoolConstant.CLOSE);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
