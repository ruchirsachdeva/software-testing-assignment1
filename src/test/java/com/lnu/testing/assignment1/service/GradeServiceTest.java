package com.lnu.testing.assignment1.service;

import static com.lnu.testing.assignment1.util.TestUtil.allGrades;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import com.lnu.testing.assignment1.model.Grade;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GradeServiceTest {

  @Autowired private GradeService service;

  @Test
  public void shouldFindAllGrades() {
    // given
    List<Grade> grades = allGrades();

    // when
    final List<Grade> response = service.findAll();

    // then
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
