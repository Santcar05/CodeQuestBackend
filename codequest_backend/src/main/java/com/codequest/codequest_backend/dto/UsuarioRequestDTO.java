package com.codequest.codequest_backend.dto;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class UsuarioRequestDTO {

    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String rol;
}
