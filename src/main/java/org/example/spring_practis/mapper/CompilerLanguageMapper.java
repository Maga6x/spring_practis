package org.example.spring_practis.mapper;

import org.example.spring_practis.dto.CompilerLanguageRequest;
import org.example.spring_practis.dto.CompilerLanguageResponse;
import org.example.spring_practis.entity.CompilerLanguage;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CompilerLanguageMapper {

    CompilerLanguageResponse toDto(CompilerLanguage  entity);
    CompilerLanguage toEntity(CompilerLanguageRequest req);
}
