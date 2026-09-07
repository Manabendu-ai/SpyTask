package riku.spytask.backend.mappers;

import riku.spytask.backend.dto.TaskDTO;
import riku.spytask.backend.entity.Tasks;

public interface TaskManager {
    Tasks toTask(TaskDTO taskDTO);
    TaskDTO toDTO(Tasks tasks);
}
