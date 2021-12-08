package com.searchengine.controllerTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.searchengine.MongoDB.controllers.ContactsController;
import com.searchengine.MongoDB.models.Contacts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class MongoDBContactsControllerTest {
    @Mock
    ContactsController contactsControllerMock;
    private Contacts contact, updatedContact;

    @Test
    void getAllContacts() {
        List<Contacts> contacts = new ArrayList<Contacts>();
        contact = new Contacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        contacts.add(contact);

        Mockito.when(contactsControllerMock.getAllContactsByFirstName(null)).thenReturn(new ResponseEntity<>(contacts, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getAllContactsByFirstName(null), new ResponseEntity<>(contacts, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllContactsById() {
        contact = new Contacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");

        Mockito.when(contactsControllerMock.getContactsById(1)).thenReturn(new ResponseEntity<>(contact, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getContactsById(1), new ResponseEntity<>(contact, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void postContact() {
        contact = new Contacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");

        Mockito.when(contactsControllerMock.createContact(contact)).thenReturn(new ResponseEntity<>(contact, HttpStatus.OK));
        try {
            assertTrue(Objects.equals(contactsControllerMock.createContact(contact), new ResponseEntity<>(contact, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void updateContactById() {
        contact = new Contacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        updatedContact = new Contacts(1, "John", "Doe", "test@mail.com", 222222, "Google", "Algorithms", "Software Engineer");

        Mockito.when(contactsControllerMock.updateContactById(1, updatedContact)).thenReturn(new ResponseEntity<>(updatedContact, HttpStatus.OK));
        try {
            assertTrue(Objects.equals(contactsControllerMock.updateContactById(1, updatedContact), new ResponseEntity<>(updatedContact, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void deleteContactById() {
        contact = new Contacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");

        Mockito.when(contactsControllerMock.deleteContactById(1)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        try {
            assertTrue(Objects.equals(contactsControllerMock.deleteContactById(1), new ResponseEntity<>(HttpStatus.NO_CONTENT)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
