package org.example.spring5homework.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring5homework.domain.TaskStatus;
import org.example.spring5homework.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.example.spring5homework.domain.Task;

import java.util.List;
import java.util.Optional;

@Slf4j//ППодвинутый логгер
@AllArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    /**
     * Получить все задачи
     *
     * @return Задача
     */
    public List<Task> getAllTasks() {
        log.info("Getting all tasks");
        return taskRepository.findAll();

    }

    /**
     * Добавить задачу
     *
     * @return Задача
     */
    public Task addTask(Task task) {
        log.info("Adding new task");
        task.setStatus(TaskStatus.NOT_STARTED);
        taskRepository.save(task);
        log.info("Task added");
        return task;
    }

    /**
     * Поиск нескольких задач
     *
     * @return Список задач
     */
    public List<Task> getAllById(List<Long> ids) {
        log.info("Finding all tasks");
        return taskRepository.findAllById(ids);
    }

    public Optional<Task> getById(Long id) {
        log.info("Finding task by id");
        Optional<Task> task = taskRepository.findById(id);
        log.info("Task found");
        return task;
    }

    /**
     * Удаление задачи по ID
     */
    public void deleteById(Long id) {
        log.info("Deleting task by id");
        taskRepository.deleteById(id);
    }
}
