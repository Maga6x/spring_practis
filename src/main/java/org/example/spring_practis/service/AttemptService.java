package org.example.spring_practis.service;

import org.example.spring_practis.dto.AttemptRequest;
import org.example.spring_practis.dto.AttemptResponse;

import java.util.List;

public interface AttemptService {

    AttemptResponse create(AttemptRequest req);
    AttemptResponse get(Long id);
    List<AttemptResponse> list();
    AttemptResponse update(Long id, AttemptRequest req);
    void delete(Long id);
}
