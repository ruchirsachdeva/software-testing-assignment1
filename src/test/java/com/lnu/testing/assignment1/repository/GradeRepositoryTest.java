package com.lnu.testing.assignment1.repository;

import static com.lnu.testing.assignment1.util.TestUtil.allGrades;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.model.GradeType;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {GradeRepository.class})
@EnableAutoConfiguration
@EntityScan("com.lnu.testing.assignment1.model")
public class GradeRepositoryTest {

  @Autowired private TestEntityManager entityManager;

  @Autowired private GradeRepository repository;

  @Test
  public void shouldGetAllGrades() {
    // given
    List<Grade> grades = allGrades();
    // when
    final List<Grade> response = repository.findAll();

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

  @Test
  public void shouldGetAllGradesFromDatabase() {
    // given
    final Grade newGrade = new Grade(GradeType.A, "Data science");

    entityManager.getEntityManager().persist(newGrade);

    // when
    final List<Grade> response = repository.findAll();

    // then
    assertThat(
        response,
        hasItems(
            allOf(
                hasProperty("type", is(newGrade.getType())),
                hasProperty("course", is(newGrade.getCourse())))));
  }
}
