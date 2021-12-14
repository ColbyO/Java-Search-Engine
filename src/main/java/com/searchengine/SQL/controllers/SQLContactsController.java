package com.searchengine.SQL.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.searchengine.SQL.models.SQLContacts;
import com.searchengine.SQL.repositories.SQLContactsRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sql/")
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

    @GetMapping("/contacts/findByFirstName/{firstName}")
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

    @GetMapping("/contacts/findByLastName/{lastName}")
    public ResponseEntity<List<SQLContacts>> getAllContactsByLastName(@RequestParam(required = false) String lastName) {
        try {
            List<SQLContacts> contacts = new ArrayList<SQLContacts>();
            if(lastName == null) {
                repo.findAll().forEach(contacts::add);
            } else {
                repo.findByLastName(lastName).forEach(contacts::add);
            }
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contacts/findByEmail/{email}")
    public ResponseEntity<List<SQLContacts>> getAllContactsByEmail(@RequestParam(required = false) String email) {
        try {
            List<SQLContacts> contacts = new ArrayList<SQLContacts>();
            if(email == null) {
                repo.findAll().forEach(contacts::add);
            } else {
                repo.findByLastName(email).forEach(contacts::add);
            }
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contacts/findByPhoneNumber/{phoneNumber}")
    public ResponseEntity<List<SQLContacts>> getAllContactsByPhoneNumber(@RequestParam(required = false) String phoneNumber) {
        try {
            List<SQLContacts> contacts = new ArrayList<SQLContacts>();
            if(phoneNumber == null) {
                repo.findAll().forEach(contacts::add);
            } else {
                repo.findByPhoneNumber(phoneNumber).forEach(contacts::add);
            }
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contacts/findByCompany/{company}")
    public ResponseEntity<List<SQLContacts>> getAllContactsByCompany(@RequestParam(required = false) String company) {
        try {
            List<SQLContacts> contacts = new ArrayList<SQLContacts>();
            if(company == null) {
                repo.findAll().forEach(contacts::add);
            } else {
                repo.findByCompany(company).forEach(contacts::add);
            }
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contacts/findByDepartment/{department}")
    public ResponseEntity<List<SQLContacts>> getAllContactsByDepartment(@RequestParam(required = false) String department) {
        try {
            List<SQLContacts> contacts = new ArrayList<SQLContacts>();
            if(department == null) {
                repo.findAll().forEach(contacts::add);
            } else {
                repo.findByDepartment(department).forEach(contacts::add);
            }
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contacts/findByJobTitle/{jobTitle}")
    public ResponseEntity<List<SQLContacts>> getAllContactsByJobTitle(@RequestParam(required = false) String jobTitle) {
        try {
            List<SQLContacts> contacts = new ArrayList<SQLContacts>();
            if(jobTitle == null) {
                repo.findAll().forEach(contacts::add);
            } else {
                repo.findByJobTitle(jobTitle).forEach(contacts::add);
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
