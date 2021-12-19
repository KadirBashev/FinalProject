package com.aacademy.FinalProject.dto;

import com.aacademy.FinalProject.model.Specialty;
import com.aacademy.FinalProject.model.Student;
import com.aacademy.FinalProject.model.StudentName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class StudentDto {

    private long  id;

    private StudentName studentName;

    private Specialty specialty;
}
