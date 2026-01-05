package org.example.spring_practis.controller;


import lombok.RequiredArgsConstructor;
import org.example.spring_practis.dto.CompilerLanguageRequest;
import org.example.spring_practis.dto.CompilerLanguageResponse;
import org.example.spring_practis.entity.CompilerLanguage;
import org.example.spring_practis.service.CompilerLanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("languages")
public class CompilerLanguageController {

    private final CompilerLanguageService service;

    @PostMapping
    public CompilerLanguageResponse create(@RequestBody CompilerLanguageRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public CompilerLanguageResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<CompilerLanguageResponse> list() {
        return service.list();
    }

    @PutMapping("/{id}")
    public CompilerLanguageResponse update(@PathVariable Long id,
                                           @RequestBody CompilerLanguageRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
