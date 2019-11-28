package com.lnu.testing.assignment1.resource;


import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.model.GradeType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/grades")
  ResponseEntity<List<Grade>> getAllGrades() {
    List<Grade> grades = new ArrayList<>();
    grades.add(new Grade(1L, GradeType.A ,"Software testing"));
    grades.add(new Grade(2L,GradeType.B,"Adaptive and web semantics"));
    return new ResponseEntity(grades, HttpStatus.OK);
  }
}
