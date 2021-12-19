package com.aacademy.FinalProject.service.impl;

import com.aacademy.FinalProject.exception.DuplicateRecordException;
import com.aacademy.FinalProject.exception.ResourceNotFoundException;
import com.aacademy.FinalProject.model.Specialty;
import com.aacademy.FinalProject.repository.SpecialtyRepository;
import com.aacademy.FinalProject.service.SpecialtyService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Specialty save(Specialty specialty)
    {
            try{
                return specialtyRepository.save(specialty);
            }catch (DataIntegrityViolationException exception){
                throw  new DuplicateRecordException(String.format("Specialty %d already exists.", specialty.getSpecialty()));
            }
    }

    @Override
    public Specialty findBySpecialty(String specialty) {
        return specialtyRepository.findBySpecialty(specialty)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Specialty %d does not exists.", specialty)));
    }

    @Override
    public Set<Specialty> findAll() {
        return null;
    }
}
