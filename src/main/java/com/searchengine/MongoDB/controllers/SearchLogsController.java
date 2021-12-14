package com.searchengine.MongoDB.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.searchengine.MongoDB.models.SearchLogs;
import com.searchengine.MongoDB.repositories.SearchLogsRepo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/logs/searchLogsByUsername/{username}")
	public ResponseEntity<List<SearchLogs>> getAllLogsByUsername(@RequestParam(required = false) String username) {
        try {
            List<SearchLogs> logsData = new ArrayList<SearchLogs>();
            if(username == null) {
                repo.findAll().forEach(logsData::add);
            } else {
                repo.findByUsername(username).forEach(logsData::add);
            }
            return new ResponseEntity<>(logsData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@PostMapping("/logs")
    public ResponseEntity<SearchLogs> createSearchLogs(@RequestBody SearchLogs logs) {
        try {
            SearchLogs _logsRepo = repo
                    .save(new SearchLogs(logs.getId(), logs.getUsername(), logs.getSearchTerm(), logs.getSearchQuery(), logs.getDatabase(), logs.getCreatedAt()));
            return new ResponseEntity<>(_logsRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/logs/{id}")
    public ResponseEntity<SearchLogs> updateSearchLogsById(@PathVariable("id") long id, @RequestBody SearchLogs logs) {
        Optional<SearchLogs> logsInfo = repo.findById(id);
        if (logsInfo.isPresent()) {
            SearchLogs _logs = logsInfo.get();
            _logs.setUsername(logs.getUsername());
            _logs.setSearchTerm(logs.getSearchTerm());
            _logs.setSearchQuery(logs.getSearchQuery());
            _logs.setDatabase(logs.getDatabase());
            _logs.setCreatedAt(logs.getCreatedAt());
            return new ResponseEntity<>(repo.save(_logs), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@DeleteMapping("/logs/deleteSearchLogsById/{username}")
    public ResponseEntity<SearchLogs> deleteSearchLogsById(@PathVariable("id") long id) {
        try {
            repo.deleteById(id);;
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
