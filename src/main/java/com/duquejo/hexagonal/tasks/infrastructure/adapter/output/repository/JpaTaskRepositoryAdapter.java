package com.duquejo.hexagonal.tasks.infrastructure.adapter.output.repository;

import com.duquejo.hexagonal.tasks.domain.model.Task;
import com.duquejo.hexagonal.tasks.domain.port.output.TaskRepositoryPort;
import com.duquejo.hexagonal.tasks.infrastructure.entity.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id)
                .map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(TaskEntity::toDomainModel)
                .toList();
    }

    @Override
    public Optional<Task> update(Task task) {
        if( ! jpaTaskRepository.existsById(task.getId())) {
            return Optional.empty();
        }

        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return Optional.of(savedTaskEntity.toDomainModel());
    }

    @Override
    public boolean deleteById(Long id) {
        if( ! jpaTaskRepository.existsById(id)) {
            return false;
        }

        jpaTaskRepository.deleteById(id);
        return true;
    }
}
