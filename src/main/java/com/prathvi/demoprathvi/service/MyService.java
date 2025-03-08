package com.prathvi.demoprathvi.service;

import com.prathvi.demoprathvi.course.Course;

import java.util.*;

public interface MyService {

    public List<Course> getCourses();
    public  String addCourse(Course course);
    public  Course getCourseByID(long id);
    public  String deleteCourseById(long id);
    public Course updateCourse(Course course);
    public Course updateCourseUsingPut(long id , Course newUser);
    public Course updateCourseUsingPatch(long id,Map<String,String> newInfo);

}
