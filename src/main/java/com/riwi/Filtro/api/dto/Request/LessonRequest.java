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
public class LessonRequest {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime create_at;
    private StatusClass Status;
}
