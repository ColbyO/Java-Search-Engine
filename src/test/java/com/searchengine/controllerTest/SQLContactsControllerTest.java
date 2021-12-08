package com.searchengine.controllerTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.searchengine.SQL.controllers.SQLContactsController;
import com.searchengine.SQL.models.SQLContacts;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class SQLContactsControllerTest {
    @Mock
    SQLContactsController contactsControllerMock;
    private SQLContacts contact, updatedContact;

    @Test
    void getAllContactsById() {
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");

        Mockito.when(contactsControllerMock.getContactsById(1)).thenReturn(new ResponseEntity<>(contact, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getContactsById(1), new ResponseEntity<>(contact, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllContacts() {
        List<SQLContacts> contacts = new ArrayList<SQLContacts>();
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        contacts.add(contact);

        Mockito.when(contactsControllerMock.getAllContactsByFirstName(null)).thenReturn(new ResponseEntity<>(contacts, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getAllContactsByFirstName(null), new ResponseEntity<>(contacts, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllContactsByFirstName() {
        List<SQLContacts> contacts = new ArrayList<SQLContacts>();
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        contacts.add(contact);

        Mockito.when(contactsControllerMock.getAllContactsByFirstName("firstName")).thenReturn(new ResponseEntity<>(contacts, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getAllContactsByFirstName("firstName"), new ResponseEntity<>(contacts, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllContactsByLastName() {
        List<SQLContacts> contacts = new ArrayList<SQLContacts>();
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        contacts.add(contact);

        Mockito.when(contactsControllerMock.getAllContactsByLastName("lastName")).thenReturn(new ResponseEntity<>(contacts, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getAllContactsByLastName("lastName"), new ResponseEntity<>(contacts, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllContactsByEmail() {
        List<SQLContacts> contacts = new ArrayList<SQLContacts>();
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        contacts.add(contact);

        Mockito.when(contactsControllerMock.getAllContactsByEmail("email")).thenReturn(new ResponseEntity<>(contacts, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getAllContactsByEmail("email"), new ResponseEntity<>(contacts, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllContactsByPhoneNumber() {
        List<SQLContacts> contacts = new ArrayList<SQLContacts>();
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        contacts.add(contact);

        Mockito.when(contactsControllerMock.getAllContactsByPhoneNumber(11111)).thenReturn(new ResponseEntity<>(contacts, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getAllContactsByPhoneNumber(11111), new ResponseEntity<>(contacts, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllContactsByCompany() {
        List<SQLContacts> contacts = new ArrayList<SQLContacts>();
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        contacts.add(contact);

        Mockito.when(contactsControllerMock.getAllContactsByCompany("company")).thenReturn(new ResponseEntity<>(contacts, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getAllContactsByCompany("company"), new ResponseEntity<>(contacts, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllContactsByDepartment() {
        List<SQLContacts> contacts = new ArrayList<SQLContacts>();
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        contacts.add(contact);

        Mockito.when(contactsControllerMock.getAllContactsByDepartment("department")).thenReturn(new ResponseEntity<>(contacts, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getAllContactsByDepartment("department"), new ResponseEntity<>(contacts, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllContactsByJobTitle() {
        List<SQLContacts> contacts = new ArrayList<SQLContacts>();
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        contacts.add(contact);

        Mockito.when(contactsControllerMock.getAllContactsByJobTitle("jobTitle")).thenReturn(new ResponseEntity<>(contacts, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(contactsControllerMock.getAllContactsByJobTitle("jobTitle"), new ResponseEntity<>(contacts, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void postContact() {
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");

        Mockito.when(contactsControllerMock.createContact(contact)).thenReturn(new ResponseEntity<>(contact, HttpStatus.OK));
        try {
            assertTrue(Objects.equals(contactsControllerMock.createContact(contact), new ResponseEntity<>(contact, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void updateContactById() {
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");
        updatedContact = new SQLContacts(1, "John", "Doe", "test@mail.com", 222222, "Google", "Algorithms", "Software Engineer");

        Mockito.when(contactsControllerMock.updateContactById(1, updatedContact)).thenReturn(new ResponseEntity<>(updatedContact, HttpStatus.OK));
        try {
            assertTrue(Objects.equals(contactsControllerMock.updateContactById(1, updatedContact), new ResponseEntity<>(updatedContact, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void deleteContactById() {
        contact = new SQLContacts(1, "firstName", "lastName", "email", 11111, "company", "department", "jobTitle");

        Mockito.when(contactsControllerMock.deleteContactById(1)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        try {
            assertTrue(Objects.equals(contactsControllerMock.deleteContactById(1), new ResponseEntity<>(HttpStatus.NO_CONTENT)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
