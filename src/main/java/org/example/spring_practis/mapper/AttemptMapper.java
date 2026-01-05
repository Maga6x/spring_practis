package org.example.spring_practis.mapper;

import org.example.spring_practis.dto.AttemptRequest;
import org.example.spring_practis.dto.AttemptResponse;
import org.example.spring_practis.dto.TestRequest;
import org.example.spring_practis.dto.TestResponse;
import org.example.spring_practis.entity.Attempt;
import org.example.spring_practis.entity.Task;
import org.example.spring_practis.entity.Test;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TaskMapper.class} ,builder = @Builder(disableBuilder = true))
public interface AttemptMapper {

    @Mapping(target = "taskId", source = "task.id")
    AttemptResponse toDto(Attempt entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "task", source = "task")
    Attempt from(AttemptRequest req, Task task);
}
