package org.example.spring5homework.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Класс для ввода Аудита
 */
@Data
@MappedSuperclass // Супер класс позволяет наследоваться, не является сущностью
@EntityListeners(AuditingEntityListener.class)//Связь с Классом JpaConfig с аннотацией @EnableJpaAuditing автоматически обновляет дату и время
public class Auditable {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;
}
