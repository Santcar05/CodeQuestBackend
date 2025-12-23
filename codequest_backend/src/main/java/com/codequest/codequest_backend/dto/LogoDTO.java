package com.codequest.codequest_backend.dto;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class LogoDTO {

    private Long id;
    private String titulo;
    private String descripcion;
}
