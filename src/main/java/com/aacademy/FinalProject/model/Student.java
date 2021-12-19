package com.aacademy.FinalProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "idNumber_id",foreignKey = @ForeignKey(name = "fk_idNumber_id"))
    private IdNumber idNumber;

    @OneToOne
    @JoinColumn(name = "specialty_id",foreignKey = @ForeignKey(name = "fk_specialty_id"))
    private Specialty specialty;

    @OneToOne
    @JoinColumn(name = "StudentName_id",foreignKey = @ForeignKey(name = "fk_StudentName_id"))
    private StudentName studentName;

    @ManyToMany
    @JoinTable(
            name = "subject",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    private Set<Subject> subjects;

    @OneToOne
    @JoinColumn(name = "year_id",foreignKey = @ForeignKey(name = "fk_year_id"))
    private Year year;

}
