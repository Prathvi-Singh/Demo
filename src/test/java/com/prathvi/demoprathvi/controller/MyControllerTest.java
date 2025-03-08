//package com.prathvi.demoprathvi.controller;
//
//import com.prathvi.demoprathvi.course.Course;
//import com.prathvi.demoprathvi.service.MyService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.*;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//
//class MyControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private MyService myService;
//
//    @InjectMocks
//    private MyController myController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
//    }
//
//    @Test
//    void getCourses() throws Exception {
//        Course course1 = new Course(1, "Course1", "Description1");
//        Course course2 = new Course(2, "Course2", "Description2");
//        when(myService.getCourses()).thenReturn(Arrays.asList(course1, course2));
//
//        mockMvc.perform(get("/courses"))
//                .andExpect(status().isOk());
//
//
//        verify(myService, times(1)).getCourses();
//    }
//
//    @Test
//    void addCourses() throws Exception {
//        Course course = new Course(1L, "New Course", "New Description");
//        when(myService.addCourse(any(Course.class))).thenReturn("Course add Successfully");
//
//        mockMvc.perform(post("/courses")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(course)))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Course add Successfully"));
//
//        verify(myService, times(1)).addCourse(any(Course.class));
//    }
//
//    @Test
//    void getCourseById() throws Exception {
//        Course course = new Course(1L, "Course1", "Description1");
//        when(myService.getCourseByID(1L)).thenReturn(course);
//
//        mockMvc.perform(get("/courses/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.title").value("Course1"))
//                .andExpect(jsonPath("$.description").value("Description1"));
//
//        verify(myService, times(1)).getCourseByID(1L);
//    }
//
//    @Test
//    void changeCoursesByUsingPut() throws Exception {
//        Course updatedCourse = new Course(1L, "Updated Course", "Updated Description");
//        when(myService.updateCourseUsingPut(eq(1L), any(Course.class))).thenReturn(updatedCourse);
//
//        mockMvc.perform(put("/courses/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(updatedCourse)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.title").value("Updated Course"))
//                .andExpect(jsonPath("$.description").value("Updated Description"));
//
//        verify(myService, times(1)).updateCourseUsingPut(eq(1L), any(Course.class));
//    }
//
//    @Test
//    void deleteCourseById() throws Exception {
//        when(myService.deleteCourseById(1L)).thenReturn("Successfully Deleted");
//
//        mockMvc.perform(delete("/courses/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Successfully Deleted"));
//
//        verify(myService, times(1)).deleteCourseById(1L);
//    }
//
//    @Test
//    void changeCourseByUsingPatch() throws Exception {
//        Map<String, String> updates = new HashMap<>();
//        updates.put("title", "Patched Title");
//        updates.put("description", "Patched Description");
//
//        Course patchedCourse = new Course(1L, "Patched Title", "Patched Description");
//        when(myService.updateCourseUsingPatch(eq(1L), any(Map.class))).thenReturn(patchedCourse);
//
//        mockMvc.perform(patch("/courses/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(updates)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.title").value("Patched Title"))
//                .andExpect(jsonPath("$.description").value("Patched Description"));
//
//        verify(myService, times(1)).updateCourseUsingPatch(eq(1L), any(Map.class));
//    }
//
//    @Test
//    void usingHeader() throws Exception {
//        mockMvc.perform(get("/courses/header")
//                        .header("Custom-Header", "HeaderValue"))
//                .andExpect(status().isOk());
//
//        // Add custom assertions and logic for header-based testing here
//    }
//}
package com.prathvi.demoprathvi.controller;

import com.prathvi.demoprathvi.course.Course;
import com.prathvi.demoprathvi.service.MyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MyService myService;

    @InjectMocks
    private MyController myController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
    }

    @Test
    void getCourses() throws Exception {
        Course course1 = new Course(1L, "Course1", "Description1");
        Course course2 = new Course(2L, "Course2", "Description2");
        when(myService.getCourses()).thenReturn(Arrays.asList(course1, course2));

        mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Course1"))
                .andExpect(jsonPath("$[0].description").value("Description1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Course2"))
                .andExpect(jsonPath("$[1].description").value("Description2"));

        verify(myService, times(1)).getCourses();
    }

    @Test
    void addCourses() throws Exception {
        Course course = new Course(1L, "New Course", "New Description");
        when(myService.addCourse(course)).thenReturn("Course add Successfully");

        mockMvc.perform(post("/courses/addcourse")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(course)))
                .andExpect(status().isOk())
                .andExpect(content().string("Course add Successfully"));

        verify(myService, times(1)).addCourse(any(Course.class));
    }

    @Test
    void getCourseById() throws Exception {
        Course course = new Course(1L, "Course1", "Description1");

        // Mock successful service call
        when(myService.getCourseByID(1L)).thenReturn(course);

        // Test for successful case
        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Course1"))
                .andExpect(jsonPath("$.description").value("Description1"));

        verify(myService, times(1)).getCourseByID(1L);

        // Mock an exception being thrown by the service
        when(myService.getCourseByID(2L)).thenThrow(new RuntimeException("Course not found"));

        // Test for error case
        mockMvc.perform(get("/courses/2"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Error occurred while fetching course: Course not found"));

        verify(myService, times(1)).getCourseByID(2L);
    }


    @Test
    void changeCoursesByUsingPut() throws Exception {
        Course updatedCourse = new Course(1L, "Updated Course", "Updated Description");
        when(myService.updateCourseUsingPut(eq(1L), any(Course.class))).thenReturn(updatedCourse);

        mockMvc.perform(put("/courses/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedCourse)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Updated Course"))
                .andExpect(jsonPath("$.description").value("Updated Description"));

        verify(myService, times(1)).updateCourseUsingPut(eq(1L), any(Course.class));
    }

    @Test
    void deleteCourseById() throws Exception {
        when(myService.deleteCourseById(1L)).thenReturn("Successfully Deleted");

        mockMvc.perform(delete("/courses/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully Deleted"));

        verify(myService, times(1)).deleteCourseById(1L);
    }

    @Test
    void changeCourseByUsingPatch() throws Exception {
        Map<String, String> updates = new HashMap<>();
        updates.put("title", "Patched Title");
        updates.put("description", "Patched Description");

        Course patchedCourse = new Course(1L, "Patched Title", "Patched Description");
        when(myService.updateCourseUsingPatch(eq(1L), any(Map.class))).thenReturn(patchedCourse);

        mockMvc.perform(patch("/courses/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updates)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Patched Title"))
                .andExpect(jsonPath("$.description").value("Patched Description"));

        verify(myService, times(1)).updateCourseUsingPatch(eq(1L), any(Map.class));
    }

//    @Test
//    void usingHeader() throws Exception {
//        mockMvc.perform(get("/courses/header")
//                        .header("Custom-Header", "HeaderValue"))
//                .andExpect(status().isOk());
//
//        // Add custom assertions and logic for header-based testing here
//    }
}

