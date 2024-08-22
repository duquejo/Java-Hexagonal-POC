package com.duquejo.hexagonal.tasks.domain.port.input;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
