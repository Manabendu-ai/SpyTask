package riku.spytask.backend.mappers;

import org.springframework.scheduling.config.Task;
import riku.spytask.backend.dto.TaskDTO;

public interface TaskManager {
    Task toTask(TaskDTO taskDTO);
    TaskDTO toDTO(Task task);
}
