package org.example.spring5homework.mapper;

import org.example.spring5homework.domain.Task;
import org.example.spring5homework.domain.TaskStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Класс для преобразования SQL-запросов в объекты Task
 */

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String description = rs.getString("description");
        TaskStatus status = TaskStatus.valueOf(rs.getString("status"));
        rs.getTimestamp("lastModified").toLocalDateTime();
        return new Task(id, description, status);
    }


}
