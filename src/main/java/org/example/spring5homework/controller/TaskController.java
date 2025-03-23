package org.example.spring5homework.controller;


import lombok.RequiredArgsConstructor;
import org.example.spring5homework.config.TaskStatusConverter;
import org.example.spring5homework.domain.Task;
import org.example.spring5homework.domain.TaskStatus;
import org.example.spring5homework.repository.TaskRepository;
import org.example.spring5homework.services.StatusService;
import org.example.spring5homework.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor//Создает конструктор static и final
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskRepository;
    private final TaskService taskService;
    private final StatusService statusService;
    private final TaskStatusConverter taskStatusConverter;

    /**
     * Получить задачу по статусу
     *
     * @return Список задач
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return statusService.getTasksByStatus(status);
    }

    /**
     * Поиск задачи
     *
     * @return Задача с HTTP-статусом
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Поиск нескольких задач
     *
     * @return Задачи с HTTP-статусом
     */
    @GetMapping
    public ResponseEntity<List<Task>> getTaskByIds(@RequestParam List<Long> ids) {
        List<Task> tasks = taskService.getAllById(ids);
        if (tasks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tasks);
    }

    /**
     * Добавить задачу
     *
     * @return Задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    /**
     * Обновить статус задачи
     *
     * @return Задача, которая не может быть null
     */
    @PutMapping("/{id}")
    public Optional<Task> updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return statusService.updateTaskStatus(id, task);
    }

    /**
     * Удаление задачи по id
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }

}
