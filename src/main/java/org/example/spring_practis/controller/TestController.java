package org.example.spring_practis.controller;


import lombok.RequiredArgsConstructor;
import org.example.spring_practis.dto.TaskRequest;
import org.example.spring_practis.dto.TaskResponse;
import org.example.spring_practis.dto.TestRequest;
import org.example.spring_practis.dto.TestResponse;
import org.example.spring_practis.service.TaskService;
import org.example.spring_practis.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tasks")
public class TestController {

    private final TestService service;

    @PostMapping
    public TestResponse create(@RequestBody TestRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public TestResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<TestResponse> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public TestResponse update(@PathVariable Long id, @RequestBody TestRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
