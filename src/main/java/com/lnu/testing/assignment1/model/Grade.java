package com.lnu.testing.assignment1.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grade {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  @Enumerated(EnumType.STRING)
  private GradeType type;

  private String course;

  protected Grade() {
    // Only for use by hibernate.
  }

  public Grade(GradeType gradeType, String course) {
    this.type = gradeType;
    this.course = course;
  }

  public long getId() {
    return id;
  }

  public GradeType getType() {
    return type;
  }

  public String getCourse() {
    return course;
  }
}