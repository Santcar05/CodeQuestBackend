package com.codequest.codequest_backend.dto;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class LeccionDTO {

    private Long id;
    private Long moduloId;
    private String titulo;
    private String descripcionCorta;
    private Integer orden;
}
