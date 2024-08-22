package com.duquejo.hexagonal.tasks.application.usecase;

import com.duquejo.hexagonal.tasks.domain.model.AdditionalTaskInfo;
import com.duquejo.hexagonal.tasks.domain.port.input.GetAdditionalTaskInfoUseCase;
import com.duquejo.hexagonal.tasks.domain.port.output.ExternalRestPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalRestPort restServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return restServicePort.getAdditionalTaskInfo(id);
    }
}
