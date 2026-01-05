package org.example.spring_practis.service.impl;

import org.example.spring_practis.dto.AttemptRequest;
import org.example.spring_practis.dto.AttemptResponse;
import org.example.spring_practis.service.AttemptService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping
public class AttemptServiceImpl implements AttemptService {

    @Override
    public AttemptResponse create(AttemptRequest req) {
        return null;
    }

    @Override
    public AttemptResponse get(Long id) {
        return null;
    }

    @Override
    public List<AttemptResponse> list() {
        return List.of();
    }

    @Override
    public AttemptResponse update(Long id, AttemptRequest req) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
