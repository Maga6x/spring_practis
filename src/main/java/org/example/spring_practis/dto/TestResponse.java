package org.example.spring_practis.dto;

import jakarta.persistence.Column;
import org.example.spring_practis.entity.CompilerLanguage;
import org.example.spring_practis.entity.Task;

import java.time.LocalDateTime;

public record TestResponse(
        Long id,
        Long taskId,
        String inputValues,
        String expectedResults,
        LocalDateTime createdAt){}
