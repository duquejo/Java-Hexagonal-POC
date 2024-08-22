package com.duquejo.hexagonal.tasks.application.service;

import com.duquejo.hexagonal.tasks.domain.model.AdditionalTaskInfo;
import com.duquejo.hexagonal.tasks.domain.model.Task;
import com.duquejo.hexagonal.tasks.domain.port.input.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TaskService implements CreateTaskUseCase, UpdateTaskUseCase, GetTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return getTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return getTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return updateTaskUseCase.updateTask(id, updateTask);
    }
}
