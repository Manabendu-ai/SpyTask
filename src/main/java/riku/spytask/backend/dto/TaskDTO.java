package riku.spytask.backend.dto;

import riku.spytask.backend.entity.TaskPriority;
import riku.spytask.backend.entity.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDTO(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
