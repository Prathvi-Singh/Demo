package com.prathvi.demoprathvi.service;

import com.prathvi.demoprathvi.course.Course;
import com.prathvi.demoprathvi.courseDao.CourseDao;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyServiceTest {

    @Mock
    private CourseDao courseDao; // Mocked dependency

    @InjectMocks
    private MyServiceImpl myService; // Class under test

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void getCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "Course1", "Description1"));
        courses.add(new Course(2L, "Course2", "Description2"));

        when(courseDao.findAll()).thenReturn(courses); // Mocking behavior

        List<Course> result = myService.getCourses();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(courseDao, times(1)).findAll(); // Verifying method call
    }

    @Test
    void addCourse() {
        Course course = new Course(1L, "Course1", "Description1");

        when(courseDao.save(course)).thenReturn(course); // Mock save

        String result = myService.addCourse(course);

        assertEquals("Course add Successfully", result);
        verify(courseDao, times(1)).save(course);
    }

    @Test
    void getCourseByID() {
        Course course = new Course(1L, "Course1", "Description1");
        when(courseDao.findById(1L)).thenReturn(Optional.of(course));

        Course result = myService.getCourseByID(1L);

        assertNotNull(result);
        assertEquals("Course1", result.getTitle());
        verify(courseDao, times(1)).findById(1L);
    }

    @Test
    void getCourseByID_NotFound() {
        when(courseDao.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            myService.getCourseByID(1L);
        });

        assertEquals("Course with ID 1 not found", exception.getMessage());
        verify(courseDao, times(1)).findById(1L);
    }

    @Test
    void deleteCourseById() {
        doNothing().when(courseDao).deleteById(1L); // Mock void method

        String result = myService.deleteCourseById(1L);

        assertEquals("Successfully Deleted", result);
        verify(courseDao, times(1)).deleteById(1L);
    }

    @Test
    void updateCourse() {
        Course course = new Course(1L, "Updated Course", "Updated Description");
        when(courseDao.save(course)).thenReturn(course);

        Course result = myService.updateCourse(course);

        assertNotNull(result);
        assertEquals("Updated Course", result.getTitle());
        verify(courseDao, times(1)).save(course);
    }

    @Test
    void updateCourseUsingPut() {
        Course course = new Course(1L, "Updated Course", "Updated Description");

        when(courseDao.save(course)).thenReturn(course);

        Course result = myService.updateCourseUsingPut(1L, course);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Updated Course", result.getTitle());
        verify(courseDao, times(1)).save(course);
    }

    @Test
    void updateCourseUsingPatch() {
        Course existingCourse = new Course(1L, "Original Course", "Original Description");
        when(courseDao.findById(1L)).thenReturn(Optional.of(existingCourse));

        Map<String, String> updates = Map.of(
                "title", "Patched Title",
                "description", "Patched Description"
        );

        Course result = myService.updateCourseUsingPatch(1L, updates);

        assertNotNull(result);
        assertEquals("Patched Title", result.getTitle());
        assertEquals("Patched Description", result.getDescription());
        verify(courseDao, times(1)).findById(1L);
    }
}
