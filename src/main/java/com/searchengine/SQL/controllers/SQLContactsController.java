package com.searchengine.SQL.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.searchengine.SQL.models.SQLContacts;
import com.searchengine.SQL.repositories.SQLContactsRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/sql/api")
public class SQLContactsController {
    @Autowired
    SQLContactsRepository repo;

    @GetMapping("/contacts/{id}")
	public ResponseEntity<SQLContacts> getContactsById(@PathVariable("id") long id) {
		Optional<SQLContacts> contactData = repo.findById(id);

		if (contactData.isPresent()) {
			return new ResponseEntity<>(contactData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @GetMapping("/contacts")
    public ResponseEntity<List<SQLContacts>> getAllContactsByFirstName(@RequestParam(required = false) String firstName) {
        try {
            List<SQLContacts> contacts = new ArrayList<SQLContacts>();
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

    @PostMapping("/contacts")
    public ResponseEntity<SQLContacts> createContact(@RequestBody SQLContacts contacts) {
        try {
            SQLContacts _contactsRepo = repo
                    .save(new SQLContacts(contacts.getId(), contacts.getFirstName(), contacts.getLastName(), contacts.getEmail(), contacts.getPhoneNumber(), 
                    contacts.getCompany(), contacts.getDepartment(), contacts.getJobTitle()));
            return new ResponseEntity<>(_contactsRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<SQLContacts> updateContactById(@PathVariable("id") long id, @RequestBody SQLContacts contacts) {
        Optional<SQLContacts> contactInfo = repo.findById(id);
        if (contactInfo.isPresent()) {
            SQLContacts _contacts = contactInfo.get();
            _contacts.setFirstName(contacts.getFirstName());
            _contacts.setLastName(contacts.getLastName());
            _contacts.setEmail(contacts.getEmail());
            _contacts.setPhoneNumber(contacts.getPhoneNumber());
            _contacts.setCompany(contacts.getCompany());
            _contacts.setDepartment(contacts.getDepartment());
            _contacts.setJobTitle(contacts.getJobTitle());
            return new ResponseEntity<>(repo.save(_contacts), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<SQLContacts> deleteContactById(@PathVariable("id") long id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
