package com.codequest.codequest_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.codequest.codequest_backend.domain.Leccion;
import com.codequest.codequest_backend.dto.LeccionDTO;

@Mapper(componentModel = "spring")
public interface LeccionMapper {

    @Mapping(source = "modulo.id", target = "moduloId")
    LeccionDTO toDto(Leccion leccion);
}

