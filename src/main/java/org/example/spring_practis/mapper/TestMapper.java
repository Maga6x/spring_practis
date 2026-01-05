package org.example.spring_practis.mapper;

import org.example.spring_practis.dto.TaskRequest;
import org.example.spring_practis.dto.TaskResponse;
import org.example.spring_practis.dto.TestRequest;
import org.example.spring_practis.dto.TestResponse;
import org.example.spring_practis.entity.CompilerLanguage;
import org.example.spring_practis.entity.Task;
import org.example.spring_practis.entity.Test;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TestMapper {

    @Mapping(target = "taskId", source = "task.id")
    TestResponse toDto(Test entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "task", source = "task")
    Test from(TestRequest req, Task task);
}
