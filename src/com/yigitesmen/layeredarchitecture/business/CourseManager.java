package com.yigitesmen.layeredarchitecture.business;

import com.yigitesmen.layeredarchitecture.core.logging.Logger;
import com.yigitesmen.layeredarchitecture.dataaccess.course.CourseDAO;
import com.yigitesmen.layeredarchitecture.entities.Course;

import java.util.List;

public class CourseManager {
    private final CourseDAO courseDAO;
    private final List<Logger> loggers;
    private final List<Course> courses;

    public CourseManager(CourseDAO courseDAO, List<Logger> loggers) {
        this.courseDAO = courseDAO;
        this.loggers = loggers;
        courses = courseDAO.fetchCourses();
    }

    public void addCourse(Course course) throws Exception {
        if (isCourseExists(course))
            throw new Exception(String.format("Failed to add course: \"%s\" is already exists%n", course.getName()));

        if (course.getPrice() < 0.0)
            throw new Exception(String.format("Failed to add course: \"%s\" price is less than 0.0%n", course.getName()));

        courseDAO.addCourse(course);
        courses.add(course);
        for (Logger logger : loggers) {
            logger.log(String.format("Added course: %s", course.getName()));
        }
    }

    private boolean isCourseExists(Course course) {
        return courses.stream().anyMatch(c -> c.getName().equalsIgnoreCase(course.getName()));
    }

    public void deleteCourse(Course course) {
        courseDAO.deleteCourse(course);
        courses.remove(course);
        for (Logger logger : loggers) {
            logger.log(String.format("Deleted course: %s", course.getName()));
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getCourseCount() {
        return courses.size();
    }
}
