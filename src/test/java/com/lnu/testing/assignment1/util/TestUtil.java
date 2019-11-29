package com.lnu.testing.assignment1.util;

import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.model.GradeType;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

  public static List<Grade> allGrades() {
    List<Grade> grades = new ArrayList<>();
    grades.add(new Grade(GradeType.A, "Software testing"));
    grades.add(new Grade(GradeType.B, "Adaptive and web semantics"));
    return grades;
  }
}
