
package com.example.task_manager_app.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    private List<Item> items;

    public TaskList() {
    }

    public TaskList(Long id, String name, List<Item> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    // Getters e Setters
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // Método toString
    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
