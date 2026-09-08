package riku.spytask.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riku.spytask.backend.entity.TaskList;
import riku.spytask.backend.exceptions.ResourceNotFoundException;
import riku.spytask.backend.repository.TaskListRepository;
import riku.spytask.backend.services.TaskListService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if(taskList.getId() != null){
            throw new IllegalArgumentException("taskList with id: "+taskList.getId()+" Already exists!");
        }
        if(taskList.getTitle() == null || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("Must enter a Task title");
        }
        return taskListRepository.save(
                new TaskList(
                        null,
                        taskList.getTitle(),
                        taskList.getDescription(),
                        null,
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );
    }

    @Override
    public TaskList getTaskListByUUID(UUID id) {
        return taskListRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("TaskList with id "+id+" not found!"));
    }

//    @Override
//    public TaskList updateTaskListByUUID(UUID id, TaskList taskList) {
//        Optional<TaskList> taskListByUUID = getTaskListByUUID(id);
//        if(taskListByUUID.isPresent()){
//            TaskList upTaskList = taskListByUUID.get();
//            upTaskList.setTitle(taskList.getTitle());
//            upTaskList.setDescription(taskList.getDescription());
//            upTaskList.setDescription(taskList.getDescription());
//            upTaskList.setUpdatedAt(LocalDateTime.now());
//            return taskListRepository.save(upTaskList);
//        }
//        return null;
//    }
}
