package com.riwi.Filtro.domain.entity;

import java.time.LocalDateTime;

import com.riwi.Filtro.util.StatusClass;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public  class  Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDateTime create_at;
    private StatusClass status;


    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.REFRESH)
    @JoinColumn(name="Clase_id",referencedColumnName="id")
    private Clase ClaseId;
}