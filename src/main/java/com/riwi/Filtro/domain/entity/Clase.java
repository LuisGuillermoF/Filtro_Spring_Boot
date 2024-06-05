package com.riwi.Filtro.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.riwi.Filtro.util.StatusClass;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public  class  Clase {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime create_at;
    private StatusClass Status;

    @ToString.Exclude
    @OneToMany(mappedBy= "ClassId",cascade=CascadeType.ALL)
    private List<Student> Student;

    @ToString.Exclude
    @OneToMany(mappedBy= "ClassId",cascade=CascadeType.ALL)
    private List<Lesson> Lesson;

    //2024-06-03T14:30:00
}