package com.riwi.Filtro.infrastructure.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.Filtro.api.dto.Request.LessonRequest;
import com.riwi.Filtro.api.dto.Response.ClassResponse;
import com.riwi.Filtro.api.dto.Response.LessonResponse;
import com.riwi.Filtro.api.dto.Response.MultimediaResponse;
import com.riwi.Filtro.domain.entity.Clase;
import com.riwi.Filtro.domain.entity.Lesson;
import com.riwi.Filtro.domain.repository.ClassRepository;
import com.riwi.Filtro.domain.repository.LessonRepository;
import com.riwi.Filtro.infrastructure.abastract_services.ILessonService;
import com.riwi.Filtro.util.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService{

    @Autowired
    private final  LessonRepository objLessonRepository;

    @Autowired
    private final ClassRepository objClaseRepository;


    @Override
    public void delete(Long id) {
        this.objLessonRepository.delete(this.find(id));
    }

    @Override
    public LessonResponse create(LessonRequest request) {
        Lesson lesson = this.entityToRequest(request);

        return this.entityToResponse(this.objLessonRepository.save(lesson));
    }

    @Override
    public LessonResponse update(Long id, LessonRequest request) {
        Lesson objLesson = this.find(id);
        Lesson objLessonUpdate = this.entityToRequest(request);
        objLessonUpdate.setId(objLesson.getId());
        return this.entityToResponse(this.objLessonRepository.save(objLessonUpdate));
    }

    @Override
    public Page<LessonResponse> getAll(int page, int size) {
        if(page < 0) page = 0;

        PageRequest paginable = PageRequest.of(page, size);

        return this.objLessonRepository.findAll(paginable).map(this::entityToResponse);
    }

    @Override
    public LessonResponse getById(Long id) {
        return  this.entityToResponse(find(id));
    }

    private Lesson find(Long id){
        return this.objLessonRepository.findById(id).orElseThrow(()-> new  BadRequestException("No se encontro Lesion con ese id"));
    }

    private Lesson entityToRequest(LessonRequest request){
        Clase clase = this.objClaseRepository.findById(request.getClasesID()).orElseThrow();


        return Lesson.builder()
        .title(request.getTitle())
        .content(request.getContent())
        .create_at(LocalDateTime.now())
        .Status(request.getStatus())
        .ClaseId(clase)
        .build();
    }

    private LessonResponse entityToResponse(Lesson entity){
        // ClassResponse classresponse = ClassResponse.builder()
        // .name(entity.getClaseId().getName())
        // .id(entity.getClaseId().getId())
        // .description(entity.getClaseId().getDescription())
        // .Status(entity.getClaseId().getStatus())
        // .build();

        ClassResponse classResponse = new ClassResponse();
        BeanUtils.copyProperties(entity, classResponse);

        MultimediaResponse multimedia = new MultimediaResponse();
        BeanUtils.copyProperties(entity, multimedia);

        return LessonResponse.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .content(entity.getContent())
        .create_at(entity.getCreate_at())
        .Status(entity.getStatus())
        .multimedia(multimedia)
        .clase(classResponse)
        .build();

    }
    
}
