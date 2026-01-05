package org.example.spring_practis.dto;

import org.example.spring_practis.entity.Task;

import java.time.LocalDateTime;

public record TestRequest(
        Long taskId,
        String inputValues,
        String expectedResults){}
