package org.example.spring_practis.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.spring_practis.dto.TaskRequest;
import org.example.spring_practis.dto.TaskResponse;
import org.example.spring_practis.entity.CompilerLanguage;
import org.example.spring_practis.entity.Task;
import org.example.spring_practis.exception.NotFoundException;
import org.example.spring_practis.mapper.CompilerLanguageMapper;
import org.example.spring_practis.mapper.TaskMapper;
import org.example.spring_practis.repository.CompilerLanguageRepository;
import org.example.spring_practis.repository.TaskRepository;
import org.example.spring_practis.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final CompilerLanguageRepository languageRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskResponse create(TaskRequest req) {
        CompilerLanguage language = languageRepository.findById(req.languageId())
                .orElseThrow(() -> new NotFoundException("language not found"));
        Task task = taskMapper.from(req, language);
        return taskMapper.toDto(taskRepository.save(task));
    }

    @Override
    public TaskResponse get(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDto)
                .orElseThrow(() -> new NotFoundException("task not found"));
    }

    @Override
    public List<TaskResponse> list() {
        return taskRepository.findAll().stream().map(taskMapper::toDto).toList();
    }

    @Override
    public TaskResponse update(Long id, TaskRequest req) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("task not found"));
        CompilerLanguage language = languageRepository.findById(req.languageId())
                .orElseThrow(() -> new NotFoundException("language not found"));

        task.setLanguage(language);
        task.setName(req.name());
        task.setDescription(req.description());
        task.setTaskOrder(req.taskOrder());

        return taskMapper.toDto(taskRepository.save(task));
    }

    @Override
    public void delete(Long id) {
        if (taskRepository.existsById(id)) {
            throw new NotFoundException("task not found"+id);
        }
        taskRepository.deleteById(id);
    }
}
