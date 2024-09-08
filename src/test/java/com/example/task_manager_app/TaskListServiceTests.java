package com.example.task_manager_app;

import com.example.task_manager_app.model.TaskList;
import com.example.task_manager_app.services.TaskListService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListServiceTests {

    @Autowired
    private TaskListService taskListService;

    @Test
    void contextLoads() {
        assertNotNull(taskListService);
    }

    @Test
    void testCreateAndFindTaskList() {
        TaskList taskList = new TaskList(null, "Test Task List", null); // Ajustado para usar o construtor existente
        TaskList createdList = taskListService.createList(taskList);

        assertNotNull(createdList.getId());
        assertEquals("Test Task List", createdList.getName());

        Optional<TaskList> foundList = taskListService.getListById(createdList.getId());
        assertTrue(foundList.isPresent());
        assertEquals("Test Task List", foundList.get().getName());
    }

    @Test
    void testUpdateTaskList() {
        TaskList taskList = new TaskList(null, "Old Task List", null); // Ajustado para usar o construtor existente
        TaskList createdList = taskListService.createList(taskList);

        createdList.setName("Updated Task List");
        TaskList updatedList = taskListService.updateList(createdList);

        assertEquals("Updated Task List", updatedList.getName());
    }

    @Test
    void testDeleteTaskList() {
        TaskList taskList = new TaskList(null, "Task List to Delete", null); // Ajustado para usar o construtor existente
        TaskList createdList = taskListService.createList(taskList);

        boolean deleted = taskListService.deleteList(createdList.getId());
        assertTrue(deleted);

        Optional<TaskList> foundList = taskListService.getListById(createdList.getId());
        assertFalse(foundList.isPresent());
    }
}
