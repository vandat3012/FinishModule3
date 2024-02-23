package com.example.testmodule3.model.service.student;

import com.example.testmodule3.dto.DTOStudent;
import com.example.testmodule3.model.Student;

import java.util.List;

public interface IStudentService {
    List<DTOStudent> findAll();
    void create (Student student);
    Student findById (int id);
    void delete(int id);
    List<DTOStudent> findByName(String name);
}
