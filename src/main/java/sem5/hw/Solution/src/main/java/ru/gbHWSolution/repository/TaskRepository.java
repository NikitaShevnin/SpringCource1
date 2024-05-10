package ru.gbHWSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbHWSolution.model.Task;
import ru.gbHWSolution.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
