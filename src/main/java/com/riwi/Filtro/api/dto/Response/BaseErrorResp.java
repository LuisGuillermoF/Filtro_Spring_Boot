package com.riwi.Filtro.api.dto.Response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseErrorResp {
    private String status;
    private Integer code;
    @Builder.Default
    private LocalDateTime  date = LocalDateTime.now();
}
