package com.lnu.testing.assignment1.resource;

import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.service.GradeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired private GradeService service;

  @GetMapping("/grades")
  ResponseEntity<List<Grade>> getAllGrades() {
    return new ResponseEntity(service.findAll(), HttpStatus.OK);
  }
}
