package riku.spytask.backend.services;

import org.springframework.scheduling.config.Task;

import java.util.UUID;

public interface TaskService {
    Task createTask(UUID taskListId, Task task);
}
