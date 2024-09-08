package com.example.task_manager_app.repository;

import com.example.task_manager_app.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    
    // Método para buscar listas pelo nome
    List<TaskList> findByName(String name);

    // Método para buscar listas pelo nome contendo uma string (ignorando maiúsculas/minúsculas)
    List<TaskList> findByNameContainingIgnoreCase(String name);
}
