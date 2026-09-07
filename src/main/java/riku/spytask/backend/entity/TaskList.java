package riku.spytask.backend.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
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

    @OneToMany(mappedBy="taskList", cascade={
        CascadeType.REMOVE,
        CascadeType.PERSIST
    })
    private List<Tasks> tasks;

    @Column(name = "created_at", nullable=false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable=false)
    private LocalDateTime updatedAt;

    public TaskList(){}

    public TaskList(UUID id, String title, String description, List<Tasks> tasks, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tasks = tasks;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(id, taskList.id) && Objects.equals(title, taskList.title)
                && Objects.equals(description, taskList.description)
                && Objects.equals(tasks, taskList.tasks)
                && Objects.equals(createdAt, taskList.createdAt)
                && Objects.equals(updatedAt, taskList.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, tasks, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
