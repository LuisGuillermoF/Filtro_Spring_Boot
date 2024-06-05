package com.riwi.Filtro.domain.entity;

import java.time.LocalDateTime;


import com.riwi.Filtro.util.StatusClass;
import com.riwi.Filtro.util.Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public  class  Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private StatusClass Status;
    private LocalDateTime create_at;
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch= FetchType.LAZY,cascade=CascadeType.REFRESH)
    @JoinColumn(name = "lesson_id",referencedColumnName = "id")
    private Lesson lesson_id;
}