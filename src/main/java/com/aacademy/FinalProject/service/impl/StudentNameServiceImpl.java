package com.aacademy.FinalProject.service.impl;

import com.aacademy.FinalProject.exception.DuplicateRecordException;
import com.aacademy.FinalProject.exception.ResourceNotFoundException;
import com.aacademy.FinalProject.model.StudentName;
import com.aacademy.FinalProject.repository.StudentNameRepository;
import com.aacademy.FinalProject.service.StudentNameService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentNameServiceImpl implements StudentNameService {
    private final StudentNameRepository studentNameRepository;

    public StudentNameServiceImpl(StudentNameRepository studentNameRepository) {
        this.studentNameRepository = studentNameRepository;
    }


    @Override
    public StudentName save(StudentName studentName) {
        try{
            return studentNameRepository.save(studentName);
        }catch (DataIntegrityViolationException exception){
            throw  new DuplicateRecordException(String.format("%d already exists.", studentName.getName()));
        }
    }

    @Override
    public StudentName FindByName(String name) {
        return studentNameRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("%d does not exists.", name)));
    }

    @Override
    public Set<StudentName> findAll() {
        return null;
    }
}
