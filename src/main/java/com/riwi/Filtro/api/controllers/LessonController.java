package com.riwi.Filtro.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Filtro.api.dto.Request.LessonRequest;
import com.riwi.Filtro.api.dto.Response.LessonResponse;
import com.riwi.Filtro.infrastructure.abastract_services.ILessonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/lesson")
@AllArgsConstructor
public class LessonController {
    @Autowired
    private final ILessonService objLessonService;

    @PostMapping
    public ResponseEntity<LessonResponse> insert(@Validated @RequestBody LessonRequest request){
        return ResponseEntity.ok(this.objLessonService.create(request));
    }

    @GetMapping
    public ResponseEntity<Page<LessonResponse>> getAll(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "1") int size){
        return  ResponseEntity.ok(this.objLessonService.getAll(page -1, size));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable String id){
        this.objLessonService.delete(Long.valueOf(id));
        Map<String,String> response = new HashMap<>();
        response.put("messages", "Se elimino el curso correctamente");
        return ResponseEntity.ok(response);
    }
}
