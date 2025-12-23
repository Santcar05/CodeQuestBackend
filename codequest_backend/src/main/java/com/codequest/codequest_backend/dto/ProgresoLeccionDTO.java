package com.codequest.codequest_backend.dto;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class ProgresoLeccionDTO {

    private Long leccionId;
    private Boolean completado;
    private Integer porcentaje;
}

