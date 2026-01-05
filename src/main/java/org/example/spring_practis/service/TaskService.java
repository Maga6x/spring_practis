package org.example.spring_practis.service;

import org.example.spring_practis.dto.TaskRequest;
import org.example.spring_practis.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse create(TaskRequest req);
    TaskResponse get(Long id);
    List<TaskResponse> list();
    TaskResponse update(Long id, TaskRequest req);
    void delete(Long id);
}
