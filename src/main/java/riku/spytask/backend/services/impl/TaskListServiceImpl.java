package riku.spytask.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riku.spytask.backend.entity.TaskList;
import riku.spytask.backend.repository.TaskListRepository;
import riku.spytask.backend.services.TaskListService;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {
    private final TaskListRepository taskListRepository;

    @Autowired
    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }
}
