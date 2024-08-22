package com.duquejo.hexagonal.tasks.domain.port.output;

import com.duquejo.hexagonal.tasks.domain.model.AdditionalTaskInfo;

public interface ExternalRestPort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
