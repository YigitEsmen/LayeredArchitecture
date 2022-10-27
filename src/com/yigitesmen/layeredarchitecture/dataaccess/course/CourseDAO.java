package com.yigitesmen.layeredarchitecture.dataaccess.course;

import com.yigitesmen.layeredarchitecture.entities.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> fetchCourses();

    void addCourse(Course course);

    void deleteCourse(Course course);
}
