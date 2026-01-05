package org.example.spring_practis.controller;


import lombok.RequiredArgsConstructor;
import org.example.spring_practis.dto.AttemptRequest;
import org.example.spring_practis.dto.AttemptResponse;
import org.example.spring_practis.dto.TestRequest;
import org.example.spring_practis.dto.TestResponse;
import org.example.spring_practis.service.AttemptService;
import org.example.spring_practis.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("attempts")
public class AttemptController {

    private final AttemptService service;

    @PostMapping
    public AttemptResponse create(@RequestBody AttemptRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public AttemptResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<AttemptResponse> list() {
        return service.list();
    }

    @PutMapping("/{id}")
    public AttemptResponse update(@PathVariable Long id, @RequestBody AttemptRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
