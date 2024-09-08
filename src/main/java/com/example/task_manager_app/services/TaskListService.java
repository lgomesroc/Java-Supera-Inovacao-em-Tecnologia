package com.example.task_manager_app.services;

import com.example.task_manager_app.model.TaskList;
import com.example.task_manager_app.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository listRepository;

    public List<TaskList> getAllLists() {
        return listRepository.findAll();
    }

    public Optional<TaskList> getListById(Long id) {
        return listRepository.findById(id);
    }

    public TaskList createList(TaskList list) {
        return listRepository.save(list);
    }

    public TaskList updateList(TaskList list) {
        return listRepository.save(list);
    }

    public boolean deleteList(Long id) {
        if (listRepository.existsById(id)) {
            listRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<TaskList> getListsByName(String name) {
        // Supondo que você tem um método no repositório para isso ou adicione uma custom query
        return listRepository.findByNameContainingIgnoreCase(name);
    }

    public void setListRepository(TaskListRepository listRepository) {
        this.listRepository = listRepository;
    }
}
