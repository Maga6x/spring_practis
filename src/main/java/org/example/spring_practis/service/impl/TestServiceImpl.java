package org.example.spring_practis.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.spring_practis.dto.TestRequest;
import org.example.spring_practis.dto.TestResponse;
import org.example.spring_practis.entity.Task;
import org.example.spring_practis.entity.Test;
import org.example.spring_practis.exception.NotFoundException;
import org.example.spring_practis.mapper.TestMapper;
import org.example.spring_practis.repository.TaskRepository;
import org.example.spring_practis.repository.TestRepository;
import org.example.spring_practis.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping
@Transactional
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final TaskRepository taskRepository;
    private final TestMapper testMapper;

    @Override
    public TestResponse create(TestRequest request) {
        Task task = taskRepository.findById(request.taskId())
                .orElseThrow(() -> new NotFoundException("Task not found: " + request.taskId()));

        Test test = testMapper.from(request, task);
        return testMapper.toDto(testRepository.save(test));
    }

    @Override
    public TestResponse update(Long id, TestRequest request) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Test not found: " + id));

        Task task = taskRepository.findById(request.taskId())
                .orElseThrow(() -> new NotFoundException("Task not found: " + request.taskId()));

        test.setTask(task);
        test.setInputValues(request.inputValues());
        test.setExpectedResults(request.expectedResults());

        return testMapper.toDto(testRepository.save(test));
    }

    @Override
    public TestResponse getById(Long id) {
        return testRepository.findById(id)
                .map(testMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Test not found: " + id));
    }

    @Override
    public List<TestResponse> getAll() {
        return testRepository.findAll()
                .stream()
                .map(testMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!testRepository.existsById(id)) {
            throw new NotFoundException("Test not found: " + id);
        }
        testRepository.deleteById(id);
    }
}
