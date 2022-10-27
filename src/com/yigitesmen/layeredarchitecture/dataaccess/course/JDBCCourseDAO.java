package com.yigitesmen.layeredarchitecture.dataaccess.course;

import com.yigitesmen.layeredarchitecture.entities.Category;
import com.yigitesmen.layeredarchitecture.entities.Course;
import com.yigitesmen.layeredarchitecture.entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class JDBCCourseDAO implements CourseDAO {

    @Override
    public List<Course> fetchCourses() {
        Instructor engindemirog = new Instructor(1, "Engin Demirog", "engins-profile-image-url");
        Category category = new Category(1, "Programlama");
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "Yazılım Geliştirici Yetiştirme Kampı (C# + ANGULAR)", 69.99, engindemirog, category));
        courses.add(new Course(2, "Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)", 69.99, engindemirog, category));
        courses.add(new Course(3, "(2022) Yazılım Geliştirici Yetiştirme Kampı - JAVA", 69.99, engindemirog, category));
        courses.add(new Course(4, "Programlamaya Giriş için Temel Kurs", 39.99, engindemirog, category));
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        // some JDBC codes here
        //
        //
        System.out.printf("Added course named \"%s\" using JDBC%n", course.getName());
    }

    @Override
    public void deleteCourse(Course course) {
        // some JDBC codes here
        //
        //
        System.out.printf("Deleted course named \"%s\" using JDBC%n", course.getName());
    }
}
