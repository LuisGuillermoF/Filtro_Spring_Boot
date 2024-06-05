package com.riwi.Filtro.api.dto.Response;

import java.time.LocalDateTime;

import com.riwi.Filtro.util.StatusClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime create_at;
    private StatusClass Status;
    
}
