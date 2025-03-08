package com.prathvi.demoprathvi.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void testEquals() {
        Course course1 = new Course();
        course1.setId(1L);
        course1.setTitle("Java Programming");
        course1.setDescription("Learn Java");

        Course course2 = new Course();
        course2.setId(1L);
        course2.setTitle("Java Programming");
        course2.setDescription("Learn Java");

        assertEquals(course1, course2);
    }


    @Test
    void canEqual() {
        Course course1 = new Course();
        Course course2 = new Course();
        assertTrue(course1.canEqual(course2));
    }

    @Test
    void testHashCode() {
        Course course1 = new Course();
        course1.setId(1L);
        course1.setTitle("Java Programming");
        course1.setDescription("Learn Java");

        Course course2 = new Course();
        course2.setId(1L);
        course2.setTitle("Java Programming");
        course2.setDescription("Learn Java");

        assertEquals(course1.hashCode(), course2.hashCode());
    }


    @Test
    void getId() {
        Course course = new Course();
        course.setId(1L);
        assertEquals(1L, course.getId());
    }

    @Test
    void getTitle() {
        Course course = new Course();
        course.setTitle("Java Programming");
        assertEquals("Java Programming", course.getTitle());
    }

    @Test
    void getDescription() {
        Course course = new Course();
        course.setDescription("Learn Java");
        assertEquals("Learn Java", course.getDescription());
    }

    @Test
    void setId() {
        Course course = new Course();
        course.setId(2L);
        assertEquals(2L, course.getId());
    }

    @Test
    void setTitle() {
        Course course = new Course();
        course.setTitle("Python Programming");
        assertEquals("Python Programming", course.getTitle());
    }

    @Test
    void setDescription() {
        Course course = new Course();
        course.setDescription("Learn Python");
        assertEquals("Learn Python", course.getDescription());
    }

    @Test
    void testToString() {
        // Arrange
        Course course = new Course();
        course.setId(1L);
        course.setTitle("Java Programming");
        course.setDescription("Learn Java");

        // Act
        String result = course.toString();

        // Assert
        String expected = "Course(id=1, title=Java Programming, description=Learn Java)";
        assertEquals(expected, result);
    }

//    @Test
//    void testToStringWithNullFields() {
//        // Arrange
//        Course course = new Course();
//        course.setId(null);
//        course.setTitle(null);
//        course.setDescription(null);
//
//        // Act
//        String result = course.toString();
//
//        // Assert
//        String expected = "Course{id=null, title='null', description='null'}";
//        assertEquals(expected, result);
//    }


}