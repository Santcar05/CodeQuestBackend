package com.codequest.codequest_backend.mapper;

import com.codequest.codequest_backend.domain.Logo;
import com.codequest.codequest_backend.dto.LogoDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogoMapper {

    LogoDTO toDto(Logo logo);
}

