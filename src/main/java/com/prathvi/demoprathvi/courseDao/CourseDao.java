package com.prathvi.demoprathvi.courseDao;

import com.prathvi.demoprathvi.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.*;

public interface CourseDao extends JpaRepository<Course,Long> {

}
