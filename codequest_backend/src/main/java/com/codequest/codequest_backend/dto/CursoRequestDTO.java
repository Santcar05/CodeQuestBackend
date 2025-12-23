package com.codequest.codequest_backend.dto;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class CursoRequestDTO {

    private String titulo;
    private String descripcion;
    private String nivel;
    private String imagenPortadaUrl;
    private String roadmap;
}
