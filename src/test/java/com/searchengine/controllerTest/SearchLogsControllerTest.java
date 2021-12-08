package com.searchengine.controllerTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.searchengine.MongoDB.controllers.SearchLogsController;
import com.searchengine.MongoDB.models.SearchLogs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class SearchLogsControllerTest {
    @Mock
    SearchLogsController searchlogsControllerMock;
    private SearchLogs logs, updatedLogs;

        @Test
    void getAllLogs() {
        List<SearchLogs> logsList = new ArrayList<SearchLogs>();
        logs = new SearchLogs(1, "ColbyO", "Colby", "MongoDB", LocalDate.now());
        logsList.add(logs);

        Mockito.when(searchlogsControllerMock.getAllLogsByUsername(null)).thenReturn(new ResponseEntity<>(logsList, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(searchlogsControllerMock.getAllLogsByUsername(null), new ResponseEntity<>(logsList, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void getAllLogsById() {
        logs = new SearchLogs(1, "ColbyO", "Colby", "MongoDB", LocalDate.now());

        Mockito.when(searchlogsControllerMock.getLogsById(1)).thenReturn(new ResponseEntity<>(logs, HttpStatus.OK));

        try {
            assertTrue(Objects.equals(searchlogsControllerMock.getLogsById(1), new ResponseEntity<>(logs, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void createLogs() {
        logs = new SearchLogs(1, "ColbyO", "Colby", "MongoDB", LocalDate.now());

        Mockito.when(searchlogsControllerMock.createSearchLogs(logs)).thenReturn(new ResponseEntity<>(logs, HttpStatus.OK));
        try {
            assertTrue(Objects.equals(searchlogsControllerMock.createSearchLogs(logs), new ResponseEntity<>(logs, HttpStatus.OK)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void updateLogsById() {
        logs = new SearchLogs(1, "ColbyO", "Colby", "MongoDB", LocalDate.now());
        updatedLogs = new SearchLogs(1, "Colby", "ColbyO", "PostgreSQL", LocalDate.now());

        Mockito.when(searchlogsControllerMock.updateSearchLogsById(1, updatedLogs)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        try {
            assertTrue(Objects.equals(searchlogsControllerMock.updateSearchLogsById(1, updatedLogs), new ResponseEntity<>(HttpStatus.NO_CONTENT)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void deleteLogsByUsername() {
        logs = new SearchLogs(1, "ColbyO", "Colby", "MongoDB", LocalDate.now());

        Mockito.when(searchlogsControllerMock.deleteSearchLogsById(1)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        try {
            assertTrue(Objects.equals(searchlogsControllerMock.deleteSearchLogsById(1), new ResponseEntity<>(HttpStatus.NO_CONTENT)));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
