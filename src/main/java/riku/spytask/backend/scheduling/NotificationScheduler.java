package riku.spytask.backend.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import riku.spytask.backend.entity.Tasks;
import riku.spytask.backend.services.TaskService;

import java.util.List;

@Component
public class NotificationScheduler {
    private static final Logger log = LoggerFactory.getLogger(NotificationScheduler.class);
    private final TaskService service;

    public NotificationScheduler(TaskService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 3000)
    public void checkForAlertingTasks(){
        List<Tasks> alerts = service.getTasksNeedingAlert();
        alerts.forEach(
                tasks -> log.info("Task With id :{}, title : {} due soon!",tasks.getId(), tasks.getTitle())
        );
    }

}
