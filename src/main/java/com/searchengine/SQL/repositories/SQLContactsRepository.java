package com.searchengine.SQL.repositories;

import java.util.List;

import com.searchengine.SQL.models.SQLContacts;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface SQLContactsRepository extends PagingAndSortingRepository<SQLContacts, Long> {
    List<SQLContacts> findByFirstName(@Param("firstName") String firstName);
}
