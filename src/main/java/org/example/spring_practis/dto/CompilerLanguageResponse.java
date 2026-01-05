package org.example.spring_practis.dto;

import org.example.spring_practis.entity.Task;

import java.time.LocalDateTime;

public record CompilerLanguageResponse(
        Long id,
        String name,
        Long compilerId,
        LocalDateTime createdAt){}
