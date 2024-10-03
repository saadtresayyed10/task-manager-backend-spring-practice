package com.saad.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
}
