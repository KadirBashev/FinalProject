package com.aacademy.FinalProject.repository;

import com.aacademy.FinalProject.model.StudentName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentNameRepository extends JpaRepository<StudentName, Long> {
    Optional<StudentName> findByName(String name);
}
