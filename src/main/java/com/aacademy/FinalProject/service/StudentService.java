package com.aacademy.FinalProject.service;

import com.aacademy.FinalProject.model.Student;

import java.util.Set;

public interface StudentService {

    Student save(Student student);

    Set<Student>  findAll();
}
