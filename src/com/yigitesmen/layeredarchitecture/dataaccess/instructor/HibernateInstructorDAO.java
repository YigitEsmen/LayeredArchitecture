package com.yigitesmen.layeredarchitecture.dataaccess.instructor;

import com.yigitesmen.layeredarchitecture.entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class HibernateInstructorDAO implements InstructorDAO {

    @Override
    public List<Instructor> fetchInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        instructors.add(new Instructor(1, "Engin Demirog", "engins-profile-image-url"));
        return instructors;
    }

    @Override
    public void addInstructor(Instructor instructor) {
        // some Hibernate codes here
        //
        //
        System.out.printf("Added instructor named \"%s\" using Hibernate%n", instructor.getName());
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
        // some Hibernate codes here
        //
        //
        System.out.printf("Deleted instructor named \"%s\" using Hibernate%n", instructor.getName());
    }
}
