package edu.project.repository;

import edu.project.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {
  Iterable<StudentEntity> findByStudentAge(Integer studentAge);
}
