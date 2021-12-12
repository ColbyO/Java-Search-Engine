package com.searchengine.MongoDB.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.searchengine.MongoDB.models.Contacts;
import com.searchengine.MongoDB.repositories.ContactsRepo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/mongodb/")
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

  @GetMapping("/contacts/findByFirstName/{firstName}")
  public ResponseEntity<List<Contacts>> getAllContactsByFirstName(@RequestParam(required = false) String firstName) {
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

  @GetMapping("/contacts/findByLastName/{lastName}")
  public ResponseEntity<List<Contacts>> getAllContactsByLastName(@RequestParam(required = false) String lastName) {
      try {
          List<Contacts> contacts = new ArrayList<Contacts>();
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
  public ResponseEntity<List<Contacts>> getAllContactsByEmail(@RequestParam(required = false) String email) {
      try {
          List<Contacts> contacts = new ArrayList<Contacts>();
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
  public ResponseEntity<List<Contacts>> getAllContactsByPhoneNumber(@RequestParam(required = false) String phoneNumber) {
      try {
          List<Contacts> contacts = new ArrayList<Contacts>();
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
  public ResponseEntity<List<Contacts>> getAllContactsByCompany(@RequestParam(required = false) String company) {
      try {
          List<Contacts> contacts = new ArrayList<Contacts>();
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
  public ResponseEntity<List<Contacts>> getAllContactsByDepartment(@RequestParam(required = false) String department) {
      try {
          List<Contacts> contacts = new ArrayList<Contacts>();
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
  public ResponseEntity<List<Contacts>> getAllContactsByJobTitle(@RequestParam(required = false) String jobTitle) {
      try {
          List<Contacts> contacts = new ArrayList<Contacts>();
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
    public ResponseEntity<Contacts> createContact(@RequestBody Contacts contacts) {
        try {
          Contacts _contacts = repo.save(new Contacts(contacts.getId() + 1000, contacts.getFirstName(), contacts.getLastName(), contacts.getEmail(), contacts.getPhoneNumber(), 
          contacts.getCompany(), contacts.getDepartment(), contacts.getJobTitle()));
          return new ResponseEntity<>(_contacts, HttpStatus.CREATED);
        } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }

      @PutMapping("/contacts/{id}")
      public ResponseEntity<Contacts> updateContactById(@PathVariable("id") long id, @RequestBody Contacts contacts) {
          Optional<Contacts> contactInfo = repo.findById(id);
          if (contactInfo.isPresent()) {
            Contacts _contacts = contactInfo.get();
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
      public ResponseEntity<Contacts> deleteContactById(@PathVariable("id") long id) {
          try {
              repo.deleteById(id);
              return new ResponseEntity<>(HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }
}
