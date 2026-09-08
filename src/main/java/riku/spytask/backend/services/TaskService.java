package riku.spytask.backend.services;

import riku.spytask.backend.entity.Tasks;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Tasks createTask(UUID taskListId, Tasks tasks);
    List<Tasks> getAllTasks();
}
