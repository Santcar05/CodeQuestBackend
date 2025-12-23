package com.codequest.codequest_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.codequest.codequest_backend.domain.Usuario;
import com.codequest.codequest_backend.dto.UsuarioDTO;
import com.codequest.codequest_backend.dto.UsuarioRequestDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDto(Usuario usuario);

    @Mapping(target = "contrasenaHash", ignore = true)
    Usuario toEntity(UsuarioRequestDTO dto);
}

