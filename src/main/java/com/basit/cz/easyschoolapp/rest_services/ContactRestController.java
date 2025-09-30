package com.basit.cz.easyschoolapp.rest_services;

import com.basit.cz.easyschoolapp.constant.SchoolConstant;
import com.basit.cz.easyschoolapp.model.Contact;
import com.basit.cz.easyschoolapp.model.Response;
import com.basit.cz.easyschoolapp.repository.ContactRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/contact")
public class ContactRestController {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping("/getMessageByStatus")
    public List<Contact> getMessageByStatus(@RequestParam("name") String string) {
        return contactRepository.findByStatus(string);
    }

    @PostMapping("/saveMessage")
    public ResponseEntity<Object> saveMessage(@Valid @RequestBody Contact contact, Errors errors) {
       if(errors.hasErrors()) {
           List<String> errorMessages = errors.getAllErrors().stream()
                   .map(ObjectError::getDefaultMessage)
                   .collect(Collectors.toList());

           // Return a bad request with error details
           return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
       }

       Contact contact1 = contactRepository.save(contact);
        return new ResponseEntity<>(contact1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMsg")
    public ResponseEntity<Response> deleteMsg(RequestEntity<Contact> requestEntity){
        HttpHeaders headers = requestEntity.getHeaders();
        headers.forEach((key, value) -> {
            log.info(String.format(
                    "Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
        });
        Contact contact = requestEntity.getBody();
        contactRepository.deleteById(contact.getContactId());
        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMsg("Message successfully deleted");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/closeMsg")
    public ResponseEntity<Response> closeMsg(@RequestBody Contact contactReq){
        Response response = new Response();
        Optional<Contact> contact = contactRepository.findById(contactReq.getContactId());
        if(contact.isPresent()){
            contact.get().setStatus(SchoolConstant.CLOSE);
            contactRepository.save(contact.get());
        }else{
            response.setStatusCode("400");
            response.setStatusMsg("Invalid Contact ID received");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
        response.setStatusCode("200");
        response.setStatusMsg("Message successfully closed");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
