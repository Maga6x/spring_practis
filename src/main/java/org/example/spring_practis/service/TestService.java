package org.example.spring_practis.service;

import org.example.spring_practis.dto.TestRequest;
import org.example.spring_practis.dto.TestResponse;

import java.util.List;

public interface TestService {

    TestResponse create(TestRequest request);
    TestResponse update(Long id, TestRequest request);

    TestResponse getById(Long id);
    List<TestResponse> getAll();
    void delete(Long id);
}
