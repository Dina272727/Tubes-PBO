package com.kelompok5.taskhub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime deadline;

    @ManyToOne
    private Users assignedTo;

    // Konstruktor kosong
    public Task() {
    }

    // Konstruktor dengan parameter (opsional)
    public Task(String name, String description, LocalDateTime deadline, Users assignedTo) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.assignedTo = assignedTo;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Users getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Users assignedTo) {
        this.assignedTo = assignedTo;
    }
}
