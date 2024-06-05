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

import com.riwi.Filtro.api.dto.Request.StudentRequest;
import com.riwi.Filtro.api.dto.Response.StudentResponse;
import com.riwi.Filtro.infrastructure.abastract_services.IStudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    
    @Autowired
    private final IStudentService objStudentService;

    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAll(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "1") int size){
        return  ResponseEntity.ok(this.objStudentService.getAll(page -1, size));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> insert (@Validated @RequestBody StudentRequest request){
        return  ResponseEntity.ok(this.objStudentService.create(request));
    }
}
