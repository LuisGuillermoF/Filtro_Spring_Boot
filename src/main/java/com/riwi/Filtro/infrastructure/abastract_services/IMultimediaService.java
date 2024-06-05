package com.riwi.Filtro.infrastructure.abastract_services;

import com.riwi.Filtro.api.dto.Request.MultimediaRequest;
import com.riwi.Filtro.api.dto.Response.MultimediaResponse;

public interface IMultimediaService extends CrudGeneral<MultimediaRequest,MultimediaResponse,Long>{
    public MultimediaResponse getById(Long id);
}
