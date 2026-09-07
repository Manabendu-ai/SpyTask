package riku.spytask.backend.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class Tasks {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name = "id", updatable=false, nullable=false)
    private UUID id;

    @Column(name = "title", nullable=false)
    private String title;

    @Column(name = "description", nullable=false)
    private String description;

    @Column(name="due_date")
    private LocalDateTime dueDate;

    @Column(name = "status", nullable=false)
    private TaskStatus status;

    @Column(name = "priority", nullable=false)
    private TaskPriority priority;

    @ManyToOne(fetch=FetchType.LAZY)
    private TaskList taskList;

    @Column(name = "created_at", nullable=false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable=false)
    private LocalDateTime updatedAt;

    public Tasks(){}

    public Tasks(
            UUID id, String title, String description, LocalDateTime dueDate,
            TaskStatus status, TaskPriority priority, TaskList taskList, LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.taskList = taskList;
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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
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
        Tasks tasks = (Tasks) o;
        return Objects.equals(id, tasks.id) && Objects.equals(title, tasks.title) && Objects.equals(description, tasks.description)
                && Objects.equals(dueDate, tasks.dueDate) && status == tasks.status && priority == tasks.priority
                && Objects.equals(taskList, tasks.taskList) && Objects.equals(createdAt, tasks.createdAt)
                && Objects.equals(updatedAt, tasks.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, status, priority, taskList, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", priority=" + priority +
                ", taskList=" + taskList +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
