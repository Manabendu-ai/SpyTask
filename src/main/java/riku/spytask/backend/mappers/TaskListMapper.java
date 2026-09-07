package riku.spytask.backend.mappers;

import riku.spytask.backend.dto.TaskListDTO;
import riku.spytask.backend.entity.TaskList;

public interface TaskListMapper {
    TaskList toTaskList(TaskListDTO taskListDTO);
    TaskListDTO toTaskListDTO(TaskList taskList);
}
