package com.lnu.testing.assignment1.service;

import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.repository.GradeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

  @Autowired private GradeRepository repository;

  public List<Grade> findAll() {
    return repository.findAll();
  }
}
