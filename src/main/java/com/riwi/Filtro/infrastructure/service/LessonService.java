package com.riwi.Filtro.infrastructure.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.Filtro.api.dto.Request.LessonRequest;
import com.riwi.Filtro.api.dto.Response.ClassResponse;
import com.riwi.Filtro.api.dto.Response.LessonResponse;
import com.riwi.Filtro.domain.entity.Lesson;
import com.riwi.Filtro.domain.repository.ClassRepository;
import com.riwi.Filtro.domain.repository.LessonRepository;
import com.riwi.Filtro.infrastructure.abastract_services.ILessonService;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public LessonResponse create(LessonRequest request) {
        Lesson lesson = this.entityToRequest(request);

        return this.entityToResponse(this.objLessonRepository.save(lesson));
    }

    @Override
    public LessonResponse update(Long id, LessonRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Page<LessonResponse> getAll(int page, int size) {
        if(page < 0) page = 0;

        PageRequest paginable = PageRequest.of(page, size);

        return this.objLessonRepository.findAll(paginable).map(this::entityToResponse);
    }

    @Override
    public LessonResponse getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    private Lesson entityToRequest(LessonRequest request){
        return Lesson.builder()
        .title(request.getTitle())
        .content(request.getContent())
        .create_at(LocalDateTime.now())
        .Status(request.getStatus())
        .build();
    }

    private LessonResponse entityToResponse(Lesson entity){
        ClassResponse classResponse = ClassResponse.builder()
        .id(entity.getClaseId().getId())
        .name(entity.getClaseId().getName())
        .description(entity.getClaseId().getDescription())
        .create_at(entity.getClaseId().getCreate_at())
        .Status(entity.getClaseId().getStatus())
        .build();

        return LessonResponse.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .content(entity.getContent())
        .create_at(entity.getCreate_at())
        .Status(entity.getStatus())
        .clase(classResponse)
        .build();

    }
    
}
