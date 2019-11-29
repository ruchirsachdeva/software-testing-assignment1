package com.lnu.testing.assignment1.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

class GradeTest {

  @Test
  public void shouldTest() {
    final Grade grade = new Grade(GradeType.A, "");
    assertThat(grade.getType(),is(GradeType.A));
    assertThat(grade.getCourse(),is(""));
    assertThat(grade.getId(),is(0L));
  }
}