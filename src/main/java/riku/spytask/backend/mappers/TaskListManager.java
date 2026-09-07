package riku.spytask.backend.mappers;

import riku.spytask.backend.dto.TaskListDTO;
import riku.spytask.backend.entity.TaskList;

public interface TaskListManager {
    TaskList toTaskList(TaskListDTO taskListDTO);
    TaskListDTO toTaskListDTO(TaskList taskList);
}
