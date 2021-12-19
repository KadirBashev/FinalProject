package com.aacademy.FinalProject.repository;

import com.aacademy.FinalProject.model.IdNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdNumberRepository extends JpaRepository<IdNumber, Long> {
    Optional<IdNumber> findByNumber(String number);
}
