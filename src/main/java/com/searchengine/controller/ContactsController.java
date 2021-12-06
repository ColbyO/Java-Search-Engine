package com.searchengine.controller;

import java.util.ArrayList;
import java.util.List;

import com.searchengine.models.Contacts;
import com.searchengine.repositories.ContactsRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ContactsController {
    @Autowired
    ContactsRepository repo;

    public ResponseEntity<List<Contacts>> getAllContacts(@RequestParam(required = false) String firstName) {
        try {
            List<Contacts> contacts = new ArrayList<Contacts>();
            if(firstName == null) {
                repo.findAll().forEach(contacts::add);
            } else {
                repo.findByFirstName(firstName).forEach(contacts::add);
            }
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
