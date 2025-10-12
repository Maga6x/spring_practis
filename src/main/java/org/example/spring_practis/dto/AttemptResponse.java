package org.example.spring_practis.dto;

import jakarta.persistence.*;
import org.example.spring_practis.entity.Task;

import java.time.LocalDateTime;

public record AttemptResponse (
        Long id,
        Task task,
        String answerCode,
        String passedTests,
        String failedTests,
        Double totalMark,
        LocalDateTime createdAt){}
