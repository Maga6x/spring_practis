package org.example.spring_practis.dto;

import jakarta.persistence.*;
import org.example.spring_practis.entity.CompilerLanguage;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        Long languageId,
        String name,
        String description,
        Integer taskOrder,
        LocalDateTime createdAt){}
