package com.duquejo.hexagonal.tasks.application.usecase;

import com.duquejo.hexagonal.tasks.domain.port.input.DeleteTaskUseCase;
import com.duquejo.hexagonal.tasks.domain.port.output.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }
}
