package com.lnu.testing.assignment1.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.model.GradeType;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GradeServiceTest {

  @Autowired
  private GradeService service;

  @Test
  public void shouldFindAllGrades() {
    // given
    List<Grade> grades = new ArrayList<>();
    grades.add(new Grade(1L, GradeType.A, "Software testing"));
    grades.add(new Grade(2L, GradeType.B, "Adaptive and web semantics"));

    // when
    final List<Grade> response = service.findAll();

    assertThat(response, hasSize(2));
    assertThat(
        response,
        hasItems(
            allOf(
                hasProperty("type", is(grades.get(0).getType())),
                hasProperty("course", is(grades.get(0).getCourse()))),
            allOf(
                hasProperty("type", is(grades.get(1).getType())),
                hasProperty("course", is(grades.get(1).getCourse())))));

  }

}