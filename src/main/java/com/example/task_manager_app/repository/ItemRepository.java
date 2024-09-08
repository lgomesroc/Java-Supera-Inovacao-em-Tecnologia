package com.example.task_manager_app.repository;

import com.example.task_manager_app.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    // Método para buscar itens pelo nome
    List<Item> findByName(String name);

    // Método para buscar itens pelo nome contendo uma string (ignorando maiúsculas/minúsculas)
    List<Item> findByNameContainingIgnoreCase(String name);
}
