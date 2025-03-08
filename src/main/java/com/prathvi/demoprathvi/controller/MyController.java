package com.prathvi.demoprathvi.controller;
import com.prathvi.demoprathvi.course.Course;
import com.prathvi.demoprathvi.service.MyService;
import com.prathvi.demoprathvi.service.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MyController{

      @Autowired
      public MyService myService;

      @GetMapping("/courses")
      public List<Course> getCourses(){
          System.out.println("Welocme in getcourses");
          return myService.getCourses();
      }

      @PostMapping("/courses/addcourse")
      public String addCourses(@RequestBody Course course){
          System.out.println("Welcome in addCourses "+course);
          myService.addCourse(course);
          return "Course add Successfully";
      }

      @GetMapping("/courses/{id}")
      public ResponseEntity<?> getCourseById(@PathVariable long id){
         try{
              System.out.println("Welcome in getCourseById ");
              return ResponseEntity.status(HttpStatus.OK)
                      .body(myService.getCourseByID(id));
          }
          catch(Exception e){
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                      .body("Error occurred while fetching course: " + e.getMessage());
          }

      }
      @PutMapping("/courses/{id}")
      public Course changeCoursesByUsingPut(@PathVariable long id,@RequestBody Course newUser){
           System.out.print("welcome in put " + id);
           System.out.println(newUser);
           return myService.updateCourseUsingPut(id,newUser);
      }

      @DeleteMapping("/courses/{id}")
      public String deleteCourseById(@PathVariable long id){
          System.out.println("Welcome in deleteCourseById");
          myService.deleteCourseById(id);
          return "Successfully Deleted";
      }

      @PatchMapping("/courses/{id}")
      public Course changeCourseByUsingPatch(@PathVariable long id,@RequestBody Map<String,String> newInfo){
          System.out.println("Welcome in Patch");
          return myService.updateCourseUsingPatch(id,newInfo);
      }



}
