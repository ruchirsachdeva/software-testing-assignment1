package com.lnu.testing.assignment1.service;

import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.model.GradeType;
import com.lnu.testing.assignment1.repository.GradeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

  @Autowired private GradeRepository repository;

  public List<Grade> findAll() {
    repository.findAll();
    List<Grade> grades = new ArrayList<>();
    grades.add(new Grade(1L, GradeType.A, "Software testing"));
    grades.add(new Grade(2L, GradeType.B, "Adaptive and web semantics"));
    return grades;
  }
}
