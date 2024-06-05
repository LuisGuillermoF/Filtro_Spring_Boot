package com.riwi.Filtro.api.dto.Request;

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
public class StudentRequest {
    private String name;
    private String email;
    private LocalDateTime create_at;
    private StatusClass status;
}
