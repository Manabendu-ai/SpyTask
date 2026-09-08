package riku.spytask.backend.services.impl;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import riku.spytask.backend.entity.TaskList;
import riku.spytask.backend.entity.TaskPriority;
import riku.spytask.backend.entity.TaskStatus;
import riku.spytask.backend.entity.Tasks;
import riku.spytask.backend.exceptions.ResourceNotFoundException;
import riku.spytask.backend.repository.TaskRepository;
import riku.spytask.backend.services.TaskService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskListServiceImpl taskListService;
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskListServiceImpl taskListService, TaskRepository taskRepository) {
        this.taskListService = taskListService;
        this.taskRepository = taskRepository;
    }


    @Override
    public Tasks createTask(UUID taskListId, Tasks tasks) {
        TaskList taskList = taskListService.getTaskListByUUID(taskListId);
        if(tasks.getId() != null){
            throw new IllegalArgumentException("task with id: "+tasks.getId()+" Already exists!");
        }
        if(tasks.getTitle() == null || tasks.getTitle().isBlank()){
            throw new IllegalArgumentException("Must enter a Task title");
        }
        TaskPriority priority = Optional.ofNullable(tasks.getPriority())
                        .orElse(TaskPriority.MEDIUM);
        TaskStatus status = TaskStatus.OPEN;
        return taskRepository.save(
                new Tasks(
                        null,
                        tasks.getTitle(),
                        tasks.getDescription(),
                        tasks.getDueDate(),
                        status,
                        priority,
                        taskList,
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );
    }

    @Override
    public List<Tasks> getAllTasks(UUID id) {
        return taskRepository.findByTaskListId(id)
                .orElseThrow(()->new ResourceNotFoundException("Task Not Found!"));
    }

    @Override
    public Tasks getTasksById(UUID taskListId, UUID id) {
        return taskRepository.findByTaskListIdAndId(taskListId, id)
                .orElseThrow(()->new ResourceNotFoundException("Task Not Found!"));
    }

    @Override
    public Tasks updateTasksById(UUID taskListId, Tasks tasks) {
        Tasks upTasks = getTasksById(taskListId, tasks.getId());
        upTasks.setTitle(tasks.getTitle());
        upTasks.setDescription(tasks.getDescription());
        upTasks.setDueDate(tasks.getDueDate());
        upTasks.setStatus(tasks.getStatus());
        upTasks.setPriority(tasks.getPriority());
        upTasks.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(upTasks);
    }
}
