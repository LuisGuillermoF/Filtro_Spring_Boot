package com.riwi.Filtro.api.dto.Response;

import java.time.LocalDateTime;

import com.riwi.Filtro.util.StatusClass;
import com.riwi.Filtro.util.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultimediaResponse {
    private Long id;
    private String url;
    private StatusClass Status;
    private LocalDateTime create_at;
    private Type type;

    private LessonResponse Lesson;
}
