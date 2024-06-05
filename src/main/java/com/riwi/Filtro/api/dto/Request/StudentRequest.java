package com.riwi.Filtro.api.dto.Request;

import java.io.Serializable;

import com.riwi.Filtro.util.StatusClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest implements  Serializable{
        private Long id;
    private String name;
    private String email;
    private StatusClass status;
    private Long clase;
}
