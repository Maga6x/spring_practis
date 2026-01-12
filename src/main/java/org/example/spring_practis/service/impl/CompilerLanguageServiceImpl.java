package org.example.spring_practis.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.spring_practis.dto.CompilerLanguageRequest;
import org.example.spring_practis.dto.CompilerLanguageResponse;
import org.example.spring_practis.entity.CompilerLanguage;
import org.example.spring_practis.exception.NotFoundException;
import org.example.spring_practis.mapper.CompilerLanguageMapper;
import org.example.spring_practis.repository.CompilerLanguageRepository;
import org.example.spring_practis.service.CompilerLanguageService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompilerLanguageServiceImpl implements CompilerLanguageService {

    private final CompilerLanguageRepository repository;
    private final CompilerLanguageMapper mapper;


    @Override
    public CompilerLanguageResponse create(CompilerLanguageRequest request) {
        CompilerLanguage language = repository.save(mapper.toEntity(request));
        return mapper.toDto(language);
    }

    @Override
    public CompilerLanguageResponse get(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("CompilerLanguage not found: " + id));
    }

    @Override
    public List<CompilerLanguageResponse> list() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public CompilerLanguageResponse update(Long id, CompilerLanguageRequest request) {
        CompilerLanguage language = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("CompilerLanguage not found: " + id));
        language.setName(request.name());
        language.setCompilerId(request.compilerId());
        return mapper.toDto(language);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            throw new NotFoundException("CompilerLanguage not found: " + id);
        }
        repository.deleteById(id);
    }

    //test2 ptactic
}
