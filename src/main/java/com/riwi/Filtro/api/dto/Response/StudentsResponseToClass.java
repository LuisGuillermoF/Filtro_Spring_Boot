package com.riwi.Filtro.api.dto.Response;

import java.time.LocalDateTime;

import com.riwi.Filtro.util.StatusClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentsResponseToClass {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime create_at;
    private StatusClass status;
}
