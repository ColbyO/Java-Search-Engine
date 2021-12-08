package com.searchengine.MongoDB.repositories;

import java.util.List;
import java.util.Optional;

import com.searchengine.MongoDB.models.Contacts;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface ContactsRepo extends MongoRepository<Contacts, Long> {
    Optional<Contacts> findById(long id);
    List<Contacts> findByFirstName(@Param("firstName") String firstName);
    List<Contacts> findByLastName(@Param("lastName") String lastName);
    List<Contacts> findByEmail(@Param("email") String email);
    List<Contacts> findByPhoneNumber(@Param("phoneNumber") int phoneNumber);
    List<Contacts> findByCompany(@Param("company") String company);
    List<Contacts> findByDepartment(@Param("department") String department);
    List<Contacts> findByJobTitle(@Param("jobTitle") String jobTitle);
}
