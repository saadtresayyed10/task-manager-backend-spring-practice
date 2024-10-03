package com.saad.taskmanager.repository;

import com.saad.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task, UUID> {
}
