package com.aacademy.FinalProject.service;


import com.aacademy.FinalProject.model.IdNumber;

import java.util.Set;

public interface IdNumberService {

    IdNumber findById(Long id);

    IdNumber save(IdNumber idNumber);

    IdNumber findByNumber(String number);

    Set<IdNumber> findAll();
}
