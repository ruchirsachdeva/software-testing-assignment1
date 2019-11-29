package com.lnu.testing.assignment1.repository;

import com.lnu.testing.assignment1.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {}
