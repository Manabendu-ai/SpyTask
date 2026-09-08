package riku.spytask.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import riku.spytask.backend.dto.TaskListDTO;
import riku.spytask.backend.entity.TaskList;
import riku.spytask.backend.mappers.TaskListMapper;
import riku.spytask.backend.services.TaskListService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/tasks-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    @Autowired
    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }


    @GetMapping("/")
    public List<TaskListDTO> listTaskLists(){
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toTaskListDTO)
                .toList();
    }

    @PostMapping("/")
    public TaskListDTO createTaskList(
            @RequestBody TaskListDTO taskListDTO
    ){
        return taskListMapper.toTaskListDTO(
                taskListService.createTaskList(
                taskListMapper.toTaskList(taskListDTO))
        );
    }

    @GetMapping("/{task_list_id}")
    public Optional<TaskListDTO> getTaskListById(
            @PathVariable("task_list_id") UUID id
    ){
        return Optional.ofNullable(taskListMapper.toTaskListDTO(
                taskListService.getTaskListByUUID(id).get()
        ));
    }
}
