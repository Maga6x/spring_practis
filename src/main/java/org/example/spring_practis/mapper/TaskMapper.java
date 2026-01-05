package org.example.spring_practis.mapper;

import org.example.spring_practis.dto.TaskRequest;
import org.example.spring_practis.dto.TaskResponse;
import org.example.spring_practis.entity.CompilerLanguage;
import org.example.spring_practis.entity.Task;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TaskMapper {

    @Mapping(target = "languageId", source = "language.id")
    TaskResponse toDto(Task entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "language", source = "language")
    @Mapping(target = "taskOrder", source = "req.taskOrder")
    @Mapping(target = "name", source = "req.name")
    Task from(TaskRequest req, CompilerLanguage language);
}
