package com.riwi.Filtro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.Filtro.domain.entity.Student;

public interface  StudentRepository extends JpaRepository<Student,Long>{
    
}
