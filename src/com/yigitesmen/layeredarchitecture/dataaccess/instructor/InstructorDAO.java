package com.yigitesmen.layeredarchitecture.dataaccess.instructor;

import com.yigitesmen.layeredarchitecture.entities.Instructor;

import java.util.List;

public interface InstructorDAO {

    List<Instructor> fetchInstructors();

    void addInstructor(Instructor course);

    void deleteInstructor(Instructor course);
}
