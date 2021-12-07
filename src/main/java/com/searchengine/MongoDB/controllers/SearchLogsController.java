package com.searchengine.MongoDB.controllers;

import java.util.Optional;

import com.searchengine.MongoDB.models.SearchLogs;
import com.searchengine.MongoDB.repositories.SearchLogsRepo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/mongodb/")
public class SearchLogsController {
    @Autowired
    SearchLogsRepo repo;  

    @GetMapping("/logs/{id}")
    public ResponseEntity<SearchLogs> getLogsById(@PathVariable("id") long id) {
		Optional<SearchLogs> searchLogData = repo.findById(id);

		if (searchLogData.isPresent()) {
			return new ResponseEntity<>(searchLogData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
