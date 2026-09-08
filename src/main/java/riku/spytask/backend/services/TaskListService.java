package riku.spytask.backend.services;

import riku.spytask.backend.entity.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
}
