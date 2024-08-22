package com.duquejo.hexagonal.tasks.infrastructure.entity;

import com.duquejo.hexagonal.tasks.domain.model.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "Task")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(name = "is_completed")
    private boolean isCompleted;

    @Column(name = "creation_date")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    /**
     * Maps a domain model Task object into a TaskEntity object.
     * @param task domain model task to be mapped
     * @return TaskEntity object
     */
    public static TaskEntity fromDomainModel(Task task) {
        return new TaskEntity(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.isCompleted(),
            task.getCreationDate(),
            task.getUpdatedDate()
        );
    }

    /**
     * Maps a TaskEntity object into a domain model Task
     * @return Task object
     */
    public Task toDomainModel() {
        return new Task(id, title, description, isCompleted, creationDate, updatedDate);
    }
}
