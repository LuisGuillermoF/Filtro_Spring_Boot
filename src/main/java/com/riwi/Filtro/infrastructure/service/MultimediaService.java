package com.riwi.Filtro.infrastructure.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.Filtro.api.dto.Request.MultimediaRequest;
import com.riwi.Filtro.api.dto.Response.MultimediaResponse;
import com.riwi.Filtro.domain.entity.Multimedia;
import com.riwi.Filtro.domain.repository.LessonRepository;
import com.riwi.Filtro.domain.repository.MultimediRepository;
import com.riwi.Filtro.infrastructure.abastract_services.IMultimediaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MultimediaService implements IMultimediaService{

    @Autowired
    private final MultimediRepository objMulti;

    @Autowired
    private final LessonRepository objLesson;


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

    private Multimedia entityToRequest(MultimediaRequest request){
        return Multimedia.builder()
        .url(request.getUrl())
        .Status(request.getStatus())
        .create_at(LocalDateTime.now())
        .type(request.getType())
        .build();
    }

    // private MultimediaResponse entityToResponse (Multimedia entity){
    //     LessonResponse lessonResponse = LessonResponse.builder()
    //     .id(entity.getLesson_id().getId())
    //     .title(entity.getLesson_id().getTitle())
    //     .content(entity.getLesson_id().getContent())
    //     .create_at(entity.getLesson_id().getCreate_at())
    //     .Status(entity.getLesson_id().getStatus())
    //     .build();

    //     return MultimediaResponse.builder()
    //     .url(entity.getUrl())
    //     .id(entity.getId())
    // }
    
}
