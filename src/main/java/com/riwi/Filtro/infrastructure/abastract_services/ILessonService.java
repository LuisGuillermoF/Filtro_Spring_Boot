package com.riwi.Filtro.infrastructure.abastract_services;

import com.riwi.Filtro.api.dto.Request.LessonRequest;
import com.riwi.Filtro.api.dto.Response.LessonResponse;

public interface ILessonService extends CrudGeneral<LessonRequest,LessonResponse,Long>{
    public LessonResponse getById(Long id);
}
