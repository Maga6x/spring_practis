package org.example.spring_practis.controller;


import lombok.RequiredArgsConstructor;
import org.example.spring_practis.dto.TaskRequest;
import org.example.spring_practis.dto.TaskResponse;
import org.example.spring_practis.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tasks")
public class TaskController {

    private final TaskService service;

    @PostMapping
    public TaskResponse create(@RequestBody TaskRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public TaskResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<TaskResponse> list() {
        return service.list();
    }

    @PutMapping("/{id}")
    public TaskResponse update(@PathVariable Long id, @RequestBody TaskRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
