package com.riwi.Filtro.api.dto.Request;

import com.riwi.Filtro.util.StatusClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassRequest {
    private String name;
    private String description;
    private StatusClass status;
}
