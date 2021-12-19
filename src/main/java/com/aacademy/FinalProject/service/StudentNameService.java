package com.aacademy.FinalProject.service;


import com.aacademy.FinalProject.model.StudentName;

import java.util.Set;

public interface StudentNameService {

    StudentName save(StudentName studentName);

    StudentName FindByName(String name);

    Set<StudentName> findAll();
}
