package com.lnu.testing.assignment1.repository;

import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.model.GradeType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class GradeRepository {

  public List<Grade> findAll() {
    List<Grade> grades = new ArrayList<>();
    grades.add(new Grade(1L, GradeType.A, "Software testing"));
    grades.add(new Grade(2L, GradeType.B, "Adaptive and web semantics"));
    return grades;
  }
}
