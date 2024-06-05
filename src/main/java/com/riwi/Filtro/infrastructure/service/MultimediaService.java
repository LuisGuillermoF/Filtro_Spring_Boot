package com.riwi.Filtro.infrastructure.service;

import org.springframework.data.domain.Page;

import com.riwi.Filtro.api.dto.Request.MultimediaRequest;
import com.riwi.Filtro.api.dto.Response.MultimediaResponse;
import com.riwi.Filtro.infrastructure.abastract_services.IMultimediaService;

public class MultimediaService implements IMultimediaService{

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public MultimediaResponse create(MultimediaRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public MultimediaResponse update(Long id, MultimediaRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Page<MultimediaResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public MultimediaResponse getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    
    
}
