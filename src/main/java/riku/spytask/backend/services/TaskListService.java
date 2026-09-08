package riku.spytask.backend.services;

import riku.spytask.backend.entity.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
    TaskList getTaskListByUUID(UUID id);
    TaskList updateTaskListByUUID(UUID id, TaskList taskList);
}
