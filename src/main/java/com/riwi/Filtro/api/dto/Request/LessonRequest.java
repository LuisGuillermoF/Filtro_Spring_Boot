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
public class LessonRequest {
    private String title;
    private String content;
    private StatusClass Status;
    private Long clase;
}
