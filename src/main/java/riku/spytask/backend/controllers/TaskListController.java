package riku.spytask.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import riku.spytask.backend.dto.TaskListDTO;
import riku.spytask.backend.mappers.TaskListMapper;
import riku.spytask.backend.services.TaskListService;

import java.util.List;

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


    @GetMapping("/all")
    public List<TaskListDTO> listTaskLists(){
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toTaskListDTO)
                .toList();
    }
}
