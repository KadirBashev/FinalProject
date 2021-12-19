package com.aacademy.FinalProject.repository;

import com.aacademy.FinalProject.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    Optional<Specialty> findBySpecialty(String name);
}
