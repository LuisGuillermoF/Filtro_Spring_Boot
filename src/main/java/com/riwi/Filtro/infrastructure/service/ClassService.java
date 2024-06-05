package com.riwi.Filtro.infrastructure.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.Filtro.api.dto.Request.ClassRequest;
import com.riwi.Filtro.api.dto.Response.ClassResponse;
import com.riwi.Filtro.domain.entity.Clase;
import com.riwi.Filtro.domain.repository.ClassRepository;
import com.riwi.Filtro.infrastructure.abastract_services.IClassService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService implements IClassService{

    @Autowired
    private final ClassRepository objClassRepository;

    @Override
    public void delete(Long id) {
        this.objClassRepository.delete(this.find(id));
    }

    @Override
    public ClassResponse create(ClassRequest request) {
        Clase clase =  this.EntityToRequest(request);

        return  this.entityToResponse(this.objClassRepository.save(clase));
    }

    @Override
    public ClassResponse update(Long id, ClassRequest request) {
        Clase objCLase = this.find(id);
        Clase objClaseUpdate = this.EntityToRequest(request);
        objClaseUpdate.setId(objCLase.getId());
        return this.entityToResponse(this.objClassRepository.save(objClaseUpdate));
    }

    @Override
    public Page<ClassResponse> getAll(int page, int size) {
        if (page <0) page = 0;

        PageRequest paginable = PageRequest.of(page, size);

        return this.objClassRepository.findAll(paginable).map(this::entityToResponse);
    }

    @Override
    public ClassResponse getById(Long id) {
        return  this.entityToResponse(this.find(id));
    }

    private Clase find(Long id){
        return this.objClassRepository.findById(id).orElseThrow();
    }


    private Clase EntityToRequest(ClassRequest request){
        return Clase.builder()
        .name(request.getName())
        .description(request.getDescription())
        .create_at(LocalDateTime.now())
        .Status(request.getStatus())
        .build();
    }
    
    private ClassResponse entityToResponse (Clase entity){
        return ClassResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .description(entity.getDescription())
        .create_at(entity.getCreate_at())
        .Status(entity.getStatus())
        .build();
    }

    @Override
    public ClassResponse getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

    @Override
    public ClassResponse getByDescription(String description) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByDescription'");
    }


}
