package com.riwi.Filtro.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Filtro.api.dto.Request.ClassRequest;
import com.riwi.Filtro.api.dto.Response.ClassResponse;
import com.riwi.Filtro.infrastructure.abastract_services.IClassService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/class")
@AllArgsConstructor
public class ClassController {
    
    @Autowired
    private final IClassService objClassService;

    @GetMapping
    public ResponseEntity<Page<ClassResponse>> getAll(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "1") int size){
        return  ResponseEntity.ok(this.objClassService.getAll(page -1, size));
    }

    @PostMapping
    public ResponseEntity<ClassResponse> insert(@Validated @RequestBody ClassRequest request){
        return ResponseEntity.ok(this.objClassService.create(request));
    }
}
