package com.riwi.Filtro.infrastructure.abastract_services;

import com.riwi.Filtro.api.dto.Request.StudentRequest;
import com.riwi.Filtro.api.dto.Response.StudentResponse;

public interface IStudentService extends CrudGeneral<StudentRequest,StudentResponse,Long>{
    public StudentResponse getById(Long id);
}
