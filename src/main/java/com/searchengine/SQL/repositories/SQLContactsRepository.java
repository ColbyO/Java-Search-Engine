package com.searchengine.SQL.repositories;

import java.util.List;

import com.searchengine.SQL.models.SQLContacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface SQLContactsRepository extends JpaRepository<SQLContacts, Long> {
    List<SQLContacts> findByFirstName(@Param("firstName") String firstName);
    List<SQLContacts> findByLastName(@Param("lastName") String lastName);
    List<SQLContacts> findByEmail(@Param("email") String email);
    List<SQLContacts> findByPhoneNumber(@Param("phoneNumber") int phoneNumber);
    List<SQLContacts> findByCompany(@Param("company") String company);
    List<SQLContacts> findByDepartment(@Param("department") String department);
    List<SQLContacts> findByJobTitle(@Param("jobTitle") String jobTitle);
}
