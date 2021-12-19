package com.aacademy.FinalProject.dto;

import com.aacademy.FinalProject.model.IdNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class StudentResponse {
    private long id;

    private StudentDto studentDto;

}
