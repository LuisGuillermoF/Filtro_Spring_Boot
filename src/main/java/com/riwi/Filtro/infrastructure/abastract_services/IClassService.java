package com.riwi.Filtro.infrastructure.abastract_services;

import com.riwi.Filtro.api.dto.Request.ClassRequest;
import com.riwi.Filtro.api.dto.Response.ClassResponse;
import com.riwi.Filtro.api.dto.Response.ClassResponseWitchStudent;

public interface IClassService extends CrudGeneral<ClassRequest, ClassResponse, Long>{
    public ClassResponseWitchStudent getById(Long id);
    public ClassResponse getByDescription(String description);
}
