package riku.spytask.backend.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.scheduling.config.Task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="task_list")
public class TaskList {
    @Id 
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name = "id", updatable=false, nullable=false)
    private UUID id;

    @Column(name = "title", nullable=false)
    private String title;

    @Column(name = "description", nullable=false)
    private String description;

    @OneToMany(mappedBy="taskList")
    private List<Task> tasks;

    @Column(name = "created_at", nullable=false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable=false)
    private LocalDateTime updatedAt;
}
