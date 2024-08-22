package com.duquejo.hexagonal.tasks.infrastructure.config;

import com.duquejo.hexagonal.tasks.application.service.TaskService;
import com.duquejo.hexagonal.tasks.application.usecase.*;
import com.duquejo.hexagonal.tasks.domain.port.input.GetAdditionalTaskInfoUseCase;
import com.duquejo.hexagonal.tasks.domain.port.output.ExternalRestPort;
import com.duquejo.hexagonal.tasks.domain.port.output.TaskRepositoryPort;
import com.duquejo.hexagonal.tasks.infrastructure.adapter.output.rest.RestAdapter;
import com.duquejo.hexagonal.tasks.infrastructure.adapter.output.repository.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(
            TaskRepositoryPort taskRepositoryPort,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new GetTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalRestPort restServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(restServicePort);
    }

    @Bean
    public ExternalRestPort restServicePort() {
        return new RestAdapter();
    }
}
