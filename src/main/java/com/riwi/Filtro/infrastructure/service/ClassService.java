package com.riwi.Filtro.infrastructure.service;

import org.springframework.data.domain.Page;

import com.riwi.Filtro.api.dto.Request.ClassRequest;
import com.riwi.Filtro.api.dto.Response.ClassResponse;
import com.riwi.Filtro.domain.entity.Clase;
import com.riwi.Filtro.infrastructure.abastract_services.IClassService;

public class ClassService implements IClassService{

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ClassResponse create(ClassRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ClassResponse update(Long id, ClassRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Page<ClassResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ClassResponse getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    private ClassRequest entityToRequest (ClassRequest request,Clase clase){
        clase.setName(request.getName());
        clase.setDescription(request.getDescription());
        clase.setStatus(request.getStatus());
        clase.setCreate_at(request.getCreate_at());
        return clase;
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


}
