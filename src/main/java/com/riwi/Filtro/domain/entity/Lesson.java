package com.riwi.Filtro.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.riwi.Filtro.util.StatusClass;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public  class  Lesson {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private LocalDateTime create_at;
    private StatusClass Status;

    @ToString.Exclude
    @OneToMany(mappedBy="lesson_id",cascade=CascadeType.ALL)
    private List<Multimedia> multimedia;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "Class_id",referencedColumnName="id")
    private Clase ClassId;
}