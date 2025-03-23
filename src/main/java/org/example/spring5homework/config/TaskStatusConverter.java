package org.example.spring5homework.config;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.spring5homework.domain.TaskStatus;
import org.springframework.stereotype.Component;

/**
 * Конвертирует Status в String и обратно в Enum
 */
@Component
@Converter(autoApply = true)// Автоматически применяется ко всем полям с которым он используется в данном случае TaskStatus
public class TaskStatusConverter implements AttributeConverter<TaskStatus, String> {


    @Override
    public String convertToDatabaseColumn(TaskStatus status) {
        return status.name();  // Преобразует Enum в String перед сохранением в БД
    }

    @Override
    public TaskStatus convertToEntityAttribute(String status) {
        return TaskStatus.valueOf(status);  // Преобразует String обратно в Enum при загрузке из БД
    }
}


