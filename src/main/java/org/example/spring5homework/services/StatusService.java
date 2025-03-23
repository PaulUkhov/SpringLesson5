package org.example.spring5homework.services;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.spring5homework.domain.Task;
import org.example.spring5homework.domain.TaskStatus;
import org.example.spring5homework.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
@Log4j2//Логгер обычный
@AllArgsConstructor
public class StatusService {
    private TaskRepository taskRepository;
    /**
     * Получить задачи по статусу
     *
     * @return Список задач
     */
    public List<Task> getTasksByStatus(TaskStatus status) {
        log.info("Getting all tasks by status");
        return taskRepository.findByStatus(status);
    }

    /**
     * Обновить статус задачи
     *
     * @return Задача
     */
    public Optional<Task> updateTaskStatus(Long id, Task task) {
        if (!taskRepository.existsById(id)) {
            log.warn("Task with id {} not found", id);
            return Optional.empty();
        }
        log.info("Updating task with id {}", id);
        taskRepository.save(task);
        return Optional.of(task);
    }

}
