package com.example.task_manager_app.controller;

import com.example.task_manager_app.model.TaskList;
import com.example.task_manager_app.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lists")
public class TaskListController {

    @Autowired
    private TaskListService listService;

    // Endpoint para obter todas as listas
    @GetMapping
    public ResponseEntity<List<TaskList>> getAllLists() {
        List<TaskList> lists = listService.getAllLists();
        return new ResponseEntity<>(lists, HttpStatus.OK);
    }

    // Endpoint para obter uma lista pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskList> getListById(@PathVariable Long id) {
        Optional<TaskList> list = listService.getListById(id);
        if (list.isPresent()) {
            return new ResponseEntity<>(list.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para criar uma nova lista
    @PostMapping
    public ResponseEntity<TaskList> createList(@RequestBody TaskList list) {
        TaskList createdList = listService.createList(list);
        return new ResponseEntity<>(createdList, HttpStatus.CREATED);
    }

    // Endpoint para atualizar uma lista existente
    @PutMapping("/{id}")
    public ResponseEntity<TaskList> updateList(@PathVariable Long id, @RequestBody TaskList list) {
        Optional<TaskList> existingList = listService.getListById(id);
        if (existingList.isPresent()) {
            list.setId(id); // Garantir que o ID está definido para a atualização
            TaskList updatedList = listService.updateList(list);
            return new ResponseEntity<>(updatedList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar uma lista pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        if (listService.deleteList(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para obter todas as listas filtradas por nome
    @GetMapping("/filter")
    public ResponseEntity<List<TaskList>> getListsByName(@RequestParam String name) {
        List<TaskList> lists = listService.getListsByName(name);
        return new ResponseEntity<>(lists, HttpStatus.OK);
    }
}