package com.prathvi.demoprathvi.courseDao;

import com.prathvi.demoprathvi.course.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CourseDaoTest {
//    @Autowired
//    private CourseDao courseDao;
//
//    private Course course1;
//    private Course course2;
//
//    @BeforeEach
//    void setup() {
//        // Initialize shared objects
//        course1 = new Course();
//        course1.setId(1L);
//        course1.setTitle("Spring Boot Basics");
//        course1.setDescription("Learn Spring Boot from scratch");
//
//        course2 = new Course();
//        course2.setId(2L);
//        course2.setTitle("Java Advanced");
//        course2.setDescription("Deep dive into Java");
//
//        // Clean database before starting tests
//
//    }
//
//    @Test
//    void testSaveCourse() {
//        // Act
//        Course savedCourse = courseDao.save(course1);
//
//        // Assert
//        assertThat(savedCourse).isNotNull();
//        assertThat(savedCourse.getId()).isEqualTo(1L);
//    }
//
//    @Test
//    void testFindAllCourses() {
//        // Arrange
//        courseDao.save(course1);
//        courseDao.save(course2);
//
//        // Act
//        List<Course> courses = courseDao.findAll();
//
//        // Assert
//        assertThat(courses).hasSize(2);
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("Test completed, resetting states if necessary.");
//    }
}