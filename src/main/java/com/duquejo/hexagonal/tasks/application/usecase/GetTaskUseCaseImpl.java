package com.duquejo.hexagonal.tasks.application.usecase;

import com.duquejo.hexagonal.tasks.domain.model.Task;
import com.duquejo.hexagonal.tasks.domain.port.input.GetTaskUseCase;
import com.duquejo.hexagonal.tasks.domain.port.output.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class GetTaskUseCaseImpl implements GetTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
