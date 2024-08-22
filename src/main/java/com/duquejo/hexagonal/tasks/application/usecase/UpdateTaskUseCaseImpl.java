package com.duquejo.hexagonal.tasks.application.usecase;

import com.duquejo.hexagonal.tasks.domain.model.Task;
import com.duquejo.hexagonal.tasks.domain.port.input.UpdateTaskUseCase;
import com.duquejo.hexagonal.tasks.domain.port.output.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        Optional<Task> task = taskRepositoryPort.findById(id);
        return task.map( t -> {
            t.setTitle(updateTask.getTitle());
            t.setDescription(updateTask.getDescription());
            t.setCompleted(updateTask.isCompleted());
            return taskRepositoryPort.update(t);
        }).orElse(Optional.empty());
    }
}
