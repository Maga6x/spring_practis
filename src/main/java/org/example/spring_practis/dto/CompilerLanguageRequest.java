package org.example.spring_practis.dto;

import java.time.LocalDateTime;

public record CompilerLanguageRequest(
        String name,
        Long compilerId){}
