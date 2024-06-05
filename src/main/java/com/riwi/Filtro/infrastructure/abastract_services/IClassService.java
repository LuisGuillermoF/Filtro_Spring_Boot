package com.riwi.Filtro.infrastructure.abastract_services;

import com.riwi.Filtro.api.dto.Request.ClassRequest;
import com.riwi.Filtro.api.dto.Response.ClassResponse;

public interface IClassService extends CrudGeneral<ClassRequest, ClassResponse, Long>{
    public ClassResponse getById(Long id);
    public ClassResponse getByName(String name);
    public ClassResponse getByDescription(String description);
}
