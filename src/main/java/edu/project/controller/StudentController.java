package edu.project.controller;

import edu.project.model.Student;
import edu.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/register-student")
    public Student registerStudent(@RequestBody Student student){

       return service.registerStudent(student);
    }

    @GetMapping("/get-all-students")
    public List<Student> getAllStudent(){
        return(service.getAllStudents());
    }

    @GetMapping("/get-all-students-by-age/{studentAge}")
    List<Student> getAllStudentsByAge(@PathVariable Integer studentAge){
        return(service.getAllStudentsByAge(studentAge));
    }

    @GetMapping("/get-Student-by-id/{studentId}")
    Student getStudentById(@PathVariable Integer studentId){
        return(service.getStudentById(studentId));
    }

    @DeleteMapping("/delete-student/{studentId}")
    boolean deleteStudentById(@PathVariable Integer studentId){
       return service.deleteStudentById(studentId);
    }

}
