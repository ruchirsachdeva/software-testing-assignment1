package com.lnu.testing.assignment1.resource;


import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/grades")
  ResponseEntity<List<String>> getAllGrades() {
    return new ResponseEntity<>(Arrays.asList("A","B"), HttpStatus.OK);
  }
}
