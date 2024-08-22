package com.duquejo.hexagonal.tasks.application.usecase;

import com.duquejo.hexagonal.tasks.domain.model.Task;
import com.duquejo.hexagonal.tasks.domain.port.input.CreateTaskUseCase;
import com.duquejo.hexagonal.tasks.domain.port.output.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
