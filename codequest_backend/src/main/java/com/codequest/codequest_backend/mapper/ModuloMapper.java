package com.codequest.codequest_backend.mapper;

import com.codequest.codequest_backend.domain.Modulo;
import com.codequest.codequest_backend.dto.ModuloDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModuloMapper {

    @Mapping(source = "curso.id", target = "cursoId")
    ModuloDTO toDto(Modulo modulo);
}
