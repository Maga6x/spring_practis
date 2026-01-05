package org.example.spring_practis.dto;

import org.example.spring_practis.entity.Task;

import java.time.LocalDateTime;

public record AttemptRequest(
        Long taskId,
        String answerCode,
        String passedTests,
        String failedTests,
        Double totalMark){}
