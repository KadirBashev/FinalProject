package com.aacademy.FinalProject.converter;

import com.aacademy.FinalProject.dto.StudentDto;
import com.aacademy.FinalProject.model.Student;
import org.springframework.stereotype.Component;



@Component
public class StudentConverter {
    public StudentDto studentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .studentName(student.getStudentName())
                .specialty(student.getSpecialty())
                .build();
    }

    public Student toStudentResponse(Student student) {
        return Student.builder()
                .id(student.getId())
                .build();
    }
}
