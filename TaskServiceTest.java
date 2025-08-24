package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import java.util.NoSuchElementException;


import Task.TaskService;

public class TaskServiceTest {

    // Valid parameters to cut down on redundant code
    private String validName = "Legal Task Name";
    private String validDescription = "Legal Task Description";

    @AfterEach
    void teardown() throws Exception {
        TaskService.clearList();
    }

    @Test
    void testAddTask() {
        TaskService.addTask(validName, validDescription);

        // Task list is not empty, proceed with testing
        assertEquals(1, TaskService.sizeOfList());
        assertEquals("0", TaskService.getTask("0").getTaskID());
        assertEquals(validName, TaskService.getTask("0").getName());
        assertEquals(validDescription, TaskService.getTask("0").getDescription());
    }

    @Test
    void testDeleteTask() {
        // Add two tasks; IDs should be "0" and "1"
        TaskService.addTask(validName, validDescription);
        TaskService.addTask(validName, validDescription);

        // Delete task with ID "1"
        TaskService.deleteTaskByID("1");

        // Ensure the task was deleted
        Assertions.assertThrows(
            NoSuchElementException.class,
            () -> TaskService.getTask("1")
        );
    }

    @Test
    void testUpdateName() {
        String updatedValidName = "Alternate Task";
        TaskService.addTask(validName, validDescription);
        TaskService.updateNameByID("0", updatedValidName);
        assertEquals(updatedValidName, TaskService.getTask("0").getName());
    }

    @Test
    void testUpdateDescription() {
        String updatedValidDescription = "Alternate Task Description";
        TaskService.addTask(validName, validDescription);
        TaskService.updateDescriptionByID("0", updatedValidDescription);
        assertEquals(updatedValidDescription, TaskService.getTask("0").getDescription());
    }
}
