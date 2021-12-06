package com.searchengine.SQL.repositories;

import java.util.List;

import com.searchengine.SQL.models.Contacts;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "Contacts", path = "Contacts")
public interface ContactsRepository extends PagingAndSortingRepository<Contacts, Long> {
    List<Contacts> findByFirstName(@Param("firstName") String firstName);
}
