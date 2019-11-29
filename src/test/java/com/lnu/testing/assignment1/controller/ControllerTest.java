package com.lnu.testing.assignment1.controller;

import static com.lnu.testing.assignment1.util.TestUtil.allGrades;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lnu.testing.assignment1.model.Grade;
import com.lnu.testing.assignment1.service.GradeService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ControllerTest {

  @Autowired MockMvc mockMvc;

  @MockBean GradeService service;

  @Autowired private ObjectMapper objectMapper;

  @Test
  void shouldGetAllGrades() throws Exception {

    // given
    List<Grade> grades = allGrades();

    when(service.findAll()).thenReturn(grades);

    // when
    ResultActions resultActions =
        mockMvc
            .perform(MockMvcRequestBuilders.get("/grades").contentType(MediaType.APPLICATION_JSON))
            .andDo(print());
    // then
    MvcResult result = resultActions.andExpect(status().isOk()).andReturn();
    String contentAsString = result.getResponse().getContentAsString();

    List<Grade> response =
        objectMapper.readValue(contentAsString, new TypeReference<List<Grade>>() {});

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
  void shouldGetAllGradesFromGradeService() throws Exception {
    // when
    mockMvc.perform(MockMvcRequestBuilders.get("/grades").contentType(MediaType.APPLICATION_JSON));
    // then
    verify(service, times(1)).findAll();
  }
}
