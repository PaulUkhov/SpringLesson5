package org.example.spring5homework.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.springframework.data.relational.core.mapping.Table;


@EntityListeners(AuditingEntityListener.class)// Слушает класс аудитор с аннотацией @EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = true) //Создает Хеш код от супер класса
@Entity //Сущность
@Data //lombok
@AllArgsConstructor//Создает конструктор
@NoArgsConstructor//Создает пустой конструктор
@Table(name = "tasks")// Создает таблицу tasks
public class Task extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Автоматическое изменение id
    private Long id;
    @Column(nullable = false)// Не может быть null
    private String description;
    //    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // Не может быть null
    private TaskStatus status;

}
