package com.aacademy.FinalProject.service;
;
import com.aacademy.FinalProject.model.Specialty;


import java.util.Set;

public interface SpecialtyService {

    Specialty save(Specialty specialty);

    Specialty findBySpecialty(String specialty);

    Set<Specialty> findAll();
}
