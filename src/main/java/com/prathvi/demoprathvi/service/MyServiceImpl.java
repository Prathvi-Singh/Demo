package com.prathvi.demoprathvi.service;
import com.prathvi.demoprathvi.course.Course;
import com.prathvi.demoprathvi.courseDao.CourseDao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MyServiceImpl implements MyService{
    @Autowired
    public CourseDao courseDao;
    public List<Course> list;
    public MyServiceImpl(){
        super();
        list=new ArrayList<>();
    }

    @Override
    public List<Course> getCourses() {

       // System.out.println("I gt sll course ");                                                                                                                                                                                                                                                                                                                                                                                       ")
        return courseDao.findAll();
    }

    @Override
    public String addCourse(Course course) {
        System.out.println("Welocme in " +  course);
        courseDao.save(course);
        return "Course add Successfully";
    }

    @Override
    public Course getCourseByID(long id) {
        return courseDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course with ID " + id + " not found"));
    }

    @Override
    public String deleteCourseById(long id){
        courseDao.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public Course updateCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public Course updateCourseUsingPut(long id ,Course newCourse){
        System.out.println(id);
        System.out.println(newCourse);
        newCourse.setId(id);
        courseDao.save(newCourse);
        return newCourse;
    }

    @Override
    public Course updateCourseUsingPatch(long id, Map<String, String> newInfo) {
        Course c=courseDao.findById(id).orElse(null);
        newInfo.forEach((key,value)->{
            switch(key){
                case "title":
                    c.setTitle(value);
                    break;
                case "description":
                    c.setDescription(value);
                    break;
            }
        });
        return c;
    }
}
