package com.yigitesmen.layeredarchitecture;

import com.yigitesmen.layeredarchitecture.business.CategoryManager;
import com.yigitesmen.layeredarchitecture.business.CourseManager;
import com.yigitesmen.layeredarchitecture.business.InstructorManager;
import com.yigitesmen.layeredarchitecture.core.logging.DatabaseLogger;
import com.yigitesmen.layeredarchitecture.core.logging.FileLogger;
import com.yigitesmen.layeredarchitecture.core.logging.Logger;
import com.yigitesmen.layeredarchitecture.core.logging.MailLogger;
import com.yigitesmen.layeredarchitecture.dataaccess.category.HibernateCategoryDAO;
import com.yigitesmen.layeredarchitecture.dataaccess.course.JDBCCourseDAO;
import com.yigitesmen.layeredarchitecture.dataaccess.instructor.HibernateInstructorDAO;
import com.yigitesmen.layeredarchitecture.entities.Category;
import com.yigitesmen.layeredarchitecture.entities.Course;
import com.yigitesmen.layeredarchitecture.entities.Instructor;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Instructor yigitesmen = new Instructor(2, "Yigit Esmen", "yigits-profile-image-url");
        Category category = new Category(1, "Programlama");
        Course course = new Course(5, "Flutter Mobil Uygulama Kursu", -39.99, yigitesmen, category);
        List<Logger> loggers = List.of(
                new DatabaseLogger(),
                new FileLogger(),
                new MailLogger()
        );

        CourseManager courseManager = new CourseManager(new JDBCCourseDAO(), loggers);
        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDAO(), loggers);
        InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDAO(), loggers);

        try {
            courseManager.addCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            categoryManager.addCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            instructorManager.addInstructor(yigitesmen);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("%nCourse count is %d%n", courseManager.getCourseCount());
        System.out.printf("Category count is %d%n", categoryManager.getCategoryCount());
        System.out.printf("Instructor count is %d%n", instructorManager.getInstructorCount());
    }
}