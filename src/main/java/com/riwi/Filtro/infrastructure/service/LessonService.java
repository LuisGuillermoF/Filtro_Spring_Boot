package com.riwi.Filtro.infrastructure.service;

import org.springframework.data.domain.Page;

import com.riwi.Filtro.api.dto.Request.LessonRequest;
import com.riwi.Filtro.api.dto.Response.LessonResponse;
import com.riwi.Filtro.infrastructure.abastract_services.ILessonService;

public class LessonService implements ILessonService{

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public LessonResponse create(LessonRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public LessonResponse update(Long id, LessonRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Page<LessonResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public LessonResponse getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    
}
