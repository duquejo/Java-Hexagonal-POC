package com.duquejo.hexagonal.tasks.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Task {
    private Long id;
    private String title;
    private String description;
    private boolean isCompleted;

    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;
}
