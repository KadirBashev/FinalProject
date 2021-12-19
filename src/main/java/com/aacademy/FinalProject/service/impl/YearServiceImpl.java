package com.aacademy.FinalProject.service.impl;

import com.aacademy.FinalProject.exception.DuplicateRecordException;
import com.aacademy.FinalProject.exception.ResourceNotFoundException;
import com.aacademy.FinalProject.model.Year;
import com.aacademy.FinalProject.repository.YearRepository;
import com.aacademy.FinalProject.service.YearService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class YearServiceImpl implements YearService {

    private final YearRepository yearRepository;

    public YearServiceImpl(YearRepository yearRepository) {
        this.yearRepository = yearRepository;
    }

    @Override
    public Year save(Year year) {
        try {
            return yearRepository.save(year);
        } catch (DataIntegrityViolationException exception) {
            throw new DuplicateRecordException(String.format("Year %d already exists.", year.getYear()));
        }
    }

    @Override
    public Year findByYear(Integer year) {
        return yearRepository.findByYear(year)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Year %d does not exists.", year)));
    }

    @Override
    public Year findById(Long id) {
        return yearRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Year %d does not exists.", id)));
    }

    @Override
    public Year update(Year year, Long id) {
        Year foundYear = findById(id);
        Year updatedYear = Year.builder()
                .id(foundYear.getId())
                .year(year.getYear())
                .build();

        return save(updatedYear);
    }

}
