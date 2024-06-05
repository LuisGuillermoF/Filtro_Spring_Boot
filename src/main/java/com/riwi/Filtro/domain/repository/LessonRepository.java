package com.riwi.Filtro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.Filtro.domain.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{
    
}
