package com.duquejo.hexagonal.tasks.domain.port.input;

import com.duquejo.hexagonal.tasks.domain.model.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
