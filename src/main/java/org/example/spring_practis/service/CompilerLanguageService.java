package org.example.spring_practis.service;

import org.example.spring_practis.dto.CompilerLanguageRequest;
import org.example.spring_practis.dto.CompilerLanguageResponse;

import java.util.List;

public interface CompilerLanguageService {

    CompilerLanguageResponse create(CompilerLanguageRequest request);
    CompilerLanguageResponse get(Long id);
    List<CompilerLanguageResponse> list();
    CompilerLanguageResponse update(Long id, CompilerLanguageRequest request);
    void delete(Long id);
}
