package com.lnu.testing.assignment1.model;


public class Grade {

  private final long id;
  private final GradeType type;
  private final String course;

  public Grade(long id, GradeType gradeType, String course) {
    this.id = id;
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
