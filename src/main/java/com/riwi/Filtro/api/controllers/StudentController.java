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
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<StudentResponse> insert (@RequestBody StudentRequest request){
        return  ResponseEntity.ok(this.objStudentService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@Validated @RequestBody StudentRequest request,
    @PathVariable Long id){
        return ResponseEntity.ok(this.objStudentService.update(id, request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable String id){
        this.objStudentService.delete(Long.valueOf(id));
        Map<String,String> response = new HashMap<>();
        response.put("messages", "Se elimino el curso correctamente");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.objStudentService.getById(id));
    }
}
