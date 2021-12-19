package com.aacademy.FinalProject.repository;

import com.aacademy.FinalProject.model.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YearRepository extends JpaRepository<Year, Long> {
    Optional<Year> findByYear(Integer year);
}
