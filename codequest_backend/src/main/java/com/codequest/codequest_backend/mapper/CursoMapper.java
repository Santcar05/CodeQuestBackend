package com.codequest.codequest_backend.mapper;

import com.codequest.codequest_backend.domain.Curso;
import com.codequest.codequest_backend.dto.CursoDTO;
import com.codequest.codequest_backend.dto.CursoRequestDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    CursoDTO toDto(Curso curso);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Curso toEntity(CursoRequestDTO dto);
}
