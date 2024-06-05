package com.riwi.Filtro.infrastructure.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.Filtro.api.dto.Request.StudentRequest;
import com.riwi.Filtro.api.dto.Response.ClassResponse;
import com.riwi.Filtro.api.dto.Response.StudentResponse;
import com.riwi.Filtro.domain.entity.Clase;
import com.riwi.Filtro.domain.entity.Student;
import com.riwi.Filtro.domain.repository.ClassRepository;
import com.riwi.Filtro.domain.repository.StudentRepository;
import com.riwi.Filtro.infrastructure.abastract_services.IStudentService;
import com.riwi.Filtro.util.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService{
    @Autowired
    private final StudentRepository objStudentRepository;

    @Autowired
    private final ClassRepository objClassRepository;

    @Override
    public void delete(Long id) {
        this.objStudentRepository.delete(this.find(id));
    }

    @Override
    public StudentResponse create(StudentRequest request) {
        Student student = this.EntityToRequest(request);

        return  this.entityToResponse(this.objStudentRepository.save(student));
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {
        Student objStudent = this.find(id);
        Student objStundetUpdate = this.EntityToRequest(request);
        objStundetUpdate.setId(objStudent.getId());
        return this.entityToResponse(this.objStudentRepository.save(objStundetUpdate));
    }

    @Override
    public Page<StudentResponse> getAll(int page, int size) {
        if(page <0) page = 0;

        PageRequest paginable = PageRequest.of(page,size);

        return  this.objStudentRepository.findAll(paginable).map(this::entityToResponse);
    }

    @Override
    public StudentResponse getById(Long id) {
        return  this.entityToResponse(this.find(id));
    }

    private Student find(Long id){
        return  this.objStudentRepository.findById(id).orElseThrow();
    }

    private Student EntityToRequest  (StudentRequest request){
        Clase clase = this.objClassRepository.findById(request.getClase()).orElseThrow();
        if (clase.getId() == null) {
            throw new BadRequestException("El id ingresado es invalido no existe");
        }

        return Student.builder()
        .name(request.getName())
        .email(request.getEmail())
        .status(request.getStatus())
        .ClaseId(clase)
        .build();
    }
    
    private StudentResponse entityToResponse (Student entity){
        ClassResponse classResponse = ClassResponse.builder()
        .id(entity.getClaseId().getId())
        .name(entity.getClaseId().getName())
        .description(entity.getClaseId().getDescription())
        .create_at(entity.getClaseId().getCreate_at())
        .Status(entity.getClaseId().getStatus())
        .build();

        return StudentResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .email(entity.getEmail())
        .create_at(LocalDateTime.now())
        .status(entity.getStatus())
        .clase(classResponse)
        .build();
    }
}
