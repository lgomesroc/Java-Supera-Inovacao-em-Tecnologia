
package com.example.task_manager_app.model;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status; // Adicionado
    private boolean highlighted; // Adicionado

    @ManyToOne
    @JoinColumn(name = "list_id")
    private TaskList list;

    // Construtores
    public Item() {
    }

    public Item(Long id, String name, String status, boolean highlighted, TaskList list) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.highlighted = highlighted;
        this.list = list;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public TaskList getList() {
        return list;
    }

    public void setList(TaskList list) {
        this.list = list;
    }

    // Método toString
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", highlighted=" + highlighted +
                ", list=" + list +
                '}';
    }
}