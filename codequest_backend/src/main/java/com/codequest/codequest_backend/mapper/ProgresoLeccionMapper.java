package com.codequest.codequest_backend.mapper;

import com.codequest.codequest_backend.domain.ProgresoLeccion;
import com.codequest.codequest_backend.dto.ProgresoLeccionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProgresoLeccionMapper {

    @Mapping(source = "leccion.id", target = "leccionId")
    ProgresoLeccionDTO toDto(ProgresoLeccion progreso);
}

