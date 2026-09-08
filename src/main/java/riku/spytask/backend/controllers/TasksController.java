package riku.spytask.backend.controllers;

import org.springframework.web.bind.annotation.*;
import riku.spytask.backend.dto.TaskDTO;
import riku.spytask.backend.mappers.TaskMapper;
import riku.spytask.backend.services.TaskService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/tasks-lists/{task_list_id}/tasks")
public class TasksController {

    private final TaskService service;
    private final TaskMapper mapper;

    public TasksController(TaskService service, TaskMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/")
    public TaskDTO createTask(
            @PathVariable("task_list_id")UUID id,
            @RequestBody TaskDTO taskDTO
            ){
        return mapper.toDTO(
                service.createTask(
                        id, mapper.toTask(taskDTO)
                )
        );
    }

    @GetMapping("/")
    public List<TaskDTO> getALlTasks(@PathVariable("task_list_id")UUID id){
        return service.getAllTasks(id).stream().map(mapper::toDTO).toList();
    }

    @GetMapping("/{task_id}")
    public TaskDTO getTaskByID(
            @PathVariable("task_list_id")UUID taskListId,
            @PathVariable("task_id")UUID taskId
    ){
        return mapper.toDTO(service.getTasksById(taskListId, taskId));
    }

    @PutMapping("/")
    public TaskDTO updateTasks(
            @PathVariable("task_list_id")UUID id,
            @RequestBody TaskDTO taskDTO
    ){
        return mapper.toDTO(
                service.updateTasksById(
                        id, mapper.toTask(taskDTO)
                )
        );
    }
}
