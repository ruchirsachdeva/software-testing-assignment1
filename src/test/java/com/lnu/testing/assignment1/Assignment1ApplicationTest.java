package com.lnu.testing.assignment1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Test class added ONLY to cover main() invocation not covered by application tests.
@ExtendWith(SpringExtension.class)
public class Assignment1ApplicationTest {

  @Test
  public void testCreateStudent() {
    System.setProperty("server.port", "8081");
    Assignment1Application.main( new String[] {});
  }

}
