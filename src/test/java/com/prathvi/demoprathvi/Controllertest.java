package com.prathvi.demoprathvi;

import com.prathvi.demoprathvi.controller.MyController;
import com.prathvi.demoprathvi.course.Course;
import com.prathvi.demoprathvi.courseDao.CourseDao;
import com.prathvi.demoprathvi.service.MyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



public class Controllertest{

    @Autowired
    private MockMvc mockMvc;

    @Mock
    public MyService myService;

    @InjectMocks
    public MyController myContoller;

    public Course course1 = new Course(1,"DSA","Data Structure & Algorithm");
    public Course course2 = new Course(2,"DAA","Design Algorithm & Analysis");

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(myContoller).build();
    }

    @Test
    public void getallcourse(){
        List<Course> l= Arrays.asList(course1,course2);
        when(myService.getCourses()).thenReturn(l);
        List<Course> r=myService.getCourses();
        Assertions.assertEquals(r,l);
    }
    @Test
   public void getallCourseUsingMockmvc() throws Exception{
       List<Course> l= Arrays.asList(course1,course2);
       when(myService.getCourses()).thenReturn(l);

       mockMvc.perform(get("/courses"))  // Simulating a GET request to /courses
               .andExpect(status().isOk())
               .andExpect(content().json("["
                       + "{\"id\":1,\"title\":\"DSA\",\"description\":\"Data Structure & Algorithm\"},"
                       + "{\"id\":2,\"title\":\"DAA\",\"description\":\"Design Algorithm & Analysis\"}"
                       + "]"));
   }

}


