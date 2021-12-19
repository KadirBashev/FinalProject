package com.aacademy.FinalProject.service.impl;

import com.aacademy.FinalProject.exception.DuplicateRecordException;
import com.aacademy.FinalProject.exception.ResourceNotFoundException;
import com.aacademy.FinalProject.model.IdNumber;
import com.aacademy.FinalProject.repository.IdNumberRepository;
import com.aacademy.FinalProject.service.IdNumberService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class IdNumberServiceImpl implements IdNumberService {
    private final IdNumberRepository idNumberRepository;

    public IdNumberServiceImpl(IdNumberRepository idNumberRepository) {
        this.idNumberRepository = idNumberRepository;
    }


    @Override
    public IdNumber findById(Long id) {
        return idNumberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("IdNumber with id %d does not exist.", id)));
    }

    @Override
    public IdNumber save(IdNumber idNumber) {
        try{
            return idNumberRepository.save(idNumber);
        }catch (DataIntegrityViolationException exception){
            throw  new DuplicateRecordException(String.format("Floor with number %d already exists.", idNumber.getNumber()));
        }
    }

    @Override
    public IdNumber findByNumber(String number) {
        return idNumberRepository.findByNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("IdNumber with %d does not exists.", number)));
    }

    @Override
    public Set<IdNumber> findAll() {
        return null;
    }
}

