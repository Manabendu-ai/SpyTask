package riku.spytask.backend.mappers.impl;

import riku.spytask.backend.dto.TaskDTO;
import riku.spytask.backend.entity.Tasks;
import riku.spytask.backend.mappers.TaskManager;

public class TaskMapperImpl implements TaskManager {
    @Override
    public Tasks toTask(TaskDTO taskDTO) {
        return new Tasks(
                taskDTO.id(),
                taskDTO.title(),
                taskDTO.description(),
                taskDTO.dueDate(),
                taskDTO.status(),
                taskDTO.priority(),
                null,
                null,
                null
        );
    }

    @Override
    public TaskDTO toDTO(Tasks tasks) {
        return null;
    }


}
