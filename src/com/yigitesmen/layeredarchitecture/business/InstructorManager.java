package com.yigitesmen.layeredarchitecture.business;

import com.yigitesmen.layeredarchitecture.core.logging.Logger;
import com.yigitesmen.layeredarchitecture.dataaccess.instructor.InstructorDAO;
import com.yigitesmen.layeredarchitecture.entities.Instructor;

import java.util.List;

public class InstructorManager {
    private final InstructorDAO instructorDAO;
    private final List<Logger> loggers;
    private final List<Instructor> instructors;

    public InstructorManager(InstructorDAO instructorDAO, List<Logger> loggers) {
        this.instructorDAO = instructorDAO;
        this.loggers = loggers;
        instructors = this.instructorDAO.fetchInstructors();
    }

    public void addInstructor(Instructor instructor) throws Exception {
        if (isInstructorExists(instructor))
            throw new Exception(String.format("Failed to add instructor: \"%s\" is already exists%n", instructor.getName()));

        instructorDAO.addInstructor(instructor);
        instructors.add(instructor);
        for (Logger logger : loggers) {
            logger.log(String.format("Added instructor: %s", instructor.getName()));
        }
    }

    private boolean isInstructorExists(Instructor instructor) {
        return instructors.stream().anyMatch(c -> c.getName().equalsIgnoreCase(instructor.getName()));
    }

    public void deleteInstructor(Instructor instructor) {
        instructorDAO.deleteInstructor(instructor);
        instructors.remove(instructor);
        for (Logger logger : loggers) {
            logger.log(String.format("Deleted instructor: %s", instructor.getName()));
        }
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public int getInstructorCount() {
        return instructors.size();
    }
}
