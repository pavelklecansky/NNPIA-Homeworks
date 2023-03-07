package cz.klecansky.spring.repository;

import cz.klecansky.spring.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}