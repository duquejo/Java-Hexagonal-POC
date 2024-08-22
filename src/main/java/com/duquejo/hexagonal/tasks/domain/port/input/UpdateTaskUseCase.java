package com.duquejo.hexagonal.tasks.domain.port.input;

import com.duquejo.hexagonal.tasks.domain.model.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updateTask);
}
