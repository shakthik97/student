package edu.project.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.project.entity.StudentEntity;
import edu.project.model.Student;
import edu.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository repository;

    @Autowired
    ObjectMapper mapper;

    public Student registerStudent(Student student) {

        StudentEntity studentEntity
                = mapper.convertValue(student, StudentEntity.class);

        StudentEntity savedProduct = repository.save(studentEntity);
        return mapper.convertValue(savedProduct, Student.class);

    }

    public List<Student> getAllStudents() {
        Iterable<StudentEntity> allStudents = repository.findAll();

        List<Student> studentList = new ArrayList<>();

        allStudents.forEach(studentEntity -> {
            Student student = mapper.convertValue(studentEntity, Student.class);
            studentList.add(student);
        });

        return studentList;
    }

    public List<Student> getAllStudentsByAge(Integer studentAge) {
        Iterable<StudentEntity> allByAge = repository.findByStudentAge(studentAge);

        List<Student> studentsListedByAge = new ArrayList<>();

        allByAge.forEach(studentEntity -> {
            Student student = mapper.convertValue(studentEntity, Student.class);
            studentsListedByAge.add(student);
        });
        return studentsListedByAge;
    }

    public Student getStudentById(Integer studentId) {
        Optional<StudentEntity> studentById = repository.findById(studentId);

        return mapper.convertValue(studentById, Student.class);

    }

    public boolean deleteStudentById(Integer studentId) {
        Optional<StudentEntity> studentOptional = repository.findById(studentId);
        if(studentOptional.isPresent()) {
            repository.delete(studentOptional.get());
            return true;
        }
        return false;
    }

}
