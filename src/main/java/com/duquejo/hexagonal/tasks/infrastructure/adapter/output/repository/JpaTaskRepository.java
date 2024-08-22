package com.duquejo.hexagonal.tasks.infrastructure.adapter.output.repository;

import com.duquejo.hexagonal.tasks.infrastructure.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
