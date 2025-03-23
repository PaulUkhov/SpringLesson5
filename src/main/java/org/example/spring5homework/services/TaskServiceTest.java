//package org.example.spring5homework.services;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.example.spring5homework.domain.TaskStatus;
//import org.example.spring5homework.mapper.TaskMapper;
//import org.example.spring5homework.repository.TaskRepository;
//import org.example.spring5homework.template.SqlTemplate;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//import org.example.spring5homework.domain.Task;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.logging.Logger;
//
//@Slf4j
//@AllArgsConstructor
//@Service
//public class TaskServiceTest {
//    private final TaskMapper taskMapper;
//    private final JdbcTemplate jdbcTemplate;
//    private final SqlTemplate sqlTemplate;
//    private final TaskRepository taskRepository;
//
//    /**
//     * Получить все задачи
//     *
//     * @return Задача
//     */
//    public List<Task> getAllTasks() {
//        log.info("Getting all tasks");
//        return jdbcTemplate.query(sqlTemplate.getSelectAllTasks(), taskMapper);
//
//    }
//
//    /**
//     * Добавить задачу
//     *
//     * @return Задача
//     */
//    public Task addTask(Task task) {
//        log.info("Adding new task");
//        task.setStatus(TaskStatus.NOT_STARTED);
//        jdbcTemplate.update(sqlTemplate.getInsertTask(), new TaskMapper());
//        log.info("Task added");
//        return task;
//    }
//
//    /**
//     * Поиск нескольких задач
//     *
//     * @return Список задач
//     */
//    public List<Task> findAllById(List<Long> ids) {
//        log.info("Finding all tasks");
//        return jdbcTemplate.query(sqlTemplate.getSelectAllTasks(), taskMapper, ids);
//    }
//
//    public Task getById(Long id) {
//        log.info("Finding task by id");
//        Optional<Task> task = jdbcTemplate.query(sqlTemplate.getSelectTaskById(), taskMapper, id).stream().findFirst();
//        if (task.isEmpty()) {
//            log.info("Task not found");
//            throw new RuntimeException("Task not found");
//        }
//        log.info("Task found");
//        return task.get();
//    }
//
//    /**
//     * Удаление задачи по ID
//     */
//    public void deleteById(Long id) {
//        log.info("Deleting task by id");
//        String delQuery = sqlTemplate.getDeleteTask();
//        int rowsDeleted = jdbcTemplate.update(delQuery, id);
//        if (rowsDeleted > 0) {
//            log.info("Task deleted");
//        } else {
//            log.warn("Task deletion failed");
//        }
//    }
//}