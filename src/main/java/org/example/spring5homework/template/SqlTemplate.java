package org.example.spring5homework.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
//@ConfigurationProperties(prefix = "sql")
public class SqlTemplate {
private String selectAllTasks;
private String selectTaskById;
private String selectTasksByStatus;
private String insertTask;
private String updateTask;
private String updateTaskStatus;
private String deleteTask;
}
