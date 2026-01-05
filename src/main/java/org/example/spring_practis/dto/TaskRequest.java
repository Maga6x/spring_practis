package org.example.spring_practis.dto;

import org.example.spring_practis.entity.CompilerLanguage;

import java.time.LocalDateTime;

public record TaskRequest(
        Long languageId,
        String name,
        String description,
        Integer taskOrder){}
