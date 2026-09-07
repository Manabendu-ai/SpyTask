package riku.spytask.backend.dto;

import java.util.List;
import java.util.UUID;

public record TaskListDTO(
        UUID id,
        String title,
        String description,
        Integer count,
        Double progress,
        List<TaskDTO> tasks

) {
}
