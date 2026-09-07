package riku.spytask.backend.mappers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import riku.spytask.backend.dto.TaskListDTO;
import riku.spytask.backend.entity.TaskList;
import riku.spytask.backend.mappers.TaskListMapper;

import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapperImpl taskMapper;

    @Autowired
    public TaskListMapperImpl(TaskMapperImpl taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList toTaskList(TaskListDTO taskListDTO) {
        return new TaskList(
                taskListDTO.id(),
                taskListDTO.title(),
                taskListDTO.description(),
                Optional.ofNullable(
                        taskListDTO.tasks()
                ).map(
                        tasks -> tasks.stream()
                                .map(taskMapper::toTask).toList())
                        .orElse(null)
                ,null,
                null
        );
    }

    @Override
    public TaskListDTO toTaskListDTO(TaskList taskList) {
        return new TaskListDTO(

        )
    }
}
