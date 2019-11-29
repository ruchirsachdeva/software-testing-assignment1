package com.lnu.testing.assignment1.service;

import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.model.GradeType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

  public List<Grade> findAll() {
    List<Grade> grades = new ArrayList<>();
    grades.add(new com.lnu.testing.assignment1.model.Grade(1L, GradeType.A, "Software testing"));
    grades.add(
        new com.lnu.testing.assignment1.model.Grade(2L, GradeType.B, "Adaptive and web semantics"));
    return grades;
  }
}
