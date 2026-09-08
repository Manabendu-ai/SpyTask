package riku.spytask.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import riku.spytask.backend.dto.TaskDTO;
import riku.spytask.backend.mappers.TaskMapper;
import riku.spytask.backend.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final TaskService service;
    private final TaskMapper mapper;

    public NotificationController(TaskService service, TaskMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public List<TaskDTO> getNotifications(){
        return service.getTasksNeedingAlert().stream().map(mapper::toDTO).toList();
    }
}
