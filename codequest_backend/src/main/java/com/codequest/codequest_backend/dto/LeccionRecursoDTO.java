package com.codequest.codequest_backend.dto;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class LeccionRecursoDTO {

    private Long id;
    private Long leccionId;
    private String tipo;
    private String titulo;
    private String contenidoTexto;
    private String urlRecurso;
}
