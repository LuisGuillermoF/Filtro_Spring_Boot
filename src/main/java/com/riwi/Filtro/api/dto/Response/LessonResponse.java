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
public class LessonResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime create_at;
    private StatusClass Status;

    private ClassResponse clase;
    private MultimediaResponse multimedia;
}
