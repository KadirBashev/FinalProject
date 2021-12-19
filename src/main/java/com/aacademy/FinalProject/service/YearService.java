package com.aacademy.FinalProject.service;

import com.aacademy.FinalProject.model.Year;

import java.util.Set;

public interface YearService {

    Year save(Year year);

    Year findByYear(Integer year);

    Year findById(Long id);

    Year update(Year year, Long id);

}
