package riku.spytask.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riku.spytask.backend.entity.Tasks;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, UUID> {
    Optional<List<Tasks>> findByTaskListId(UUID id);
    Optional<Tasks> findByTaskListIdAndId(UUID taskListId, UUID id);
}
