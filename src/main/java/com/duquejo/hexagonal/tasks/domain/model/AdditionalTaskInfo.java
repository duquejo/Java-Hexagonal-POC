package com.duquejo.hexagonal.tasks.domain.model;

public record AdditionalTaskInfo(
        Long userId,
        String userName,
        String userEmail
) {}
