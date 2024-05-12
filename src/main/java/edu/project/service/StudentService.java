package edu.project.service;

import edu.project.model.Student;

import java.util.List;

public interface StudentService {

    public Student registerStudent(Student student);
    public List<Student> getAllStudents();

    public List<Student> getAllStudentsByAge(Integer studentAge);

    public Student getStudentById(Integer studentId);

    public boolean deleteStudentById(Integer studentId);

}
