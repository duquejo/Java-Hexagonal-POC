package com.duquejo.hexagonal.tasks.domain.port.input;

import com.duquejo.hexagonal.tasks.domain.model.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
