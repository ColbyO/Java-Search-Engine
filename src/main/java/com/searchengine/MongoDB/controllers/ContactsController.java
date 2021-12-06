package com.searchengine.MongoDB.controllers;

import java.util.Optional;

import com.searchengine.MongoDB.models.Contacts;
import com.searchengine.MongoDB.repositories.ContactsRepo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/mongodb/api")
public class ContactsController {
    @Autowired
    ContactsRepo repo;

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contacts> getContactsById(@PathVariable("id") long id) {
		Optional<Contacts> contactData = repo.findById(id);

		if (contactData.isPresent()) {
			return new ResponseEntity<>(contactData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/contacts")
    public ResponseEntity<Contacts> createContact(@RequestBody Contacts contacts) {
        try {
          Contacts _contacts = repo.save(new Contacts(contacts.getId() + 1000, contacts.getFirstName(), contacts.getLastName(), contacts.getEmail(), contacts.getPhoneNumber(), 
          contacts.getCompany(), contacts.getDepartment(), contacts.getJobTitle()));
          return new ResponseEntity<>(_contacts, HttpStatus.CREATED);
        } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }
}
