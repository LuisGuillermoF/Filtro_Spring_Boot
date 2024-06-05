package com.riwi.Filtro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.Filtro.domain.entity.Multimedia;

public interface MultimediRepository extends  JpaRepository<Multimedia,Long>{
    
}
