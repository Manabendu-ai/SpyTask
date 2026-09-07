package riku.spytask.backend.mappers;

import riku.spytask.backend.dto.TaskDTO;
import riku.spytask.backend.entity.Tasks;

public interface TaskMapper {
    Tasks toTask(TaskDTO taskDTO);
    TaskDTO toDTO(Tasks tasks);
}
