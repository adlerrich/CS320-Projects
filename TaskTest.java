package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;

public class TaskTest {

    // Valid parameters to cut down on redundant code
    private String validTaskID = "1001";
    private String validName = "Valid Task Name";
    private String validDescription = "A really good task name";

    @Test
    void testValidTask() {
        Task testTask = new Task(validTaskID, validName, validDescription);

        assertEquals(validTaskID, testTask.getTaskID());
        assertEquals(validName, testTask.getName());
        assertEquals(validDescription, testTask.getDescription());
    }

    @Test
    void testInvalidTaskID() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("Illegal Task ID", validName, validDescription);
        });
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(validTaskID, "Illegal Task Name that is too long", validDescription);
        });
    }

    @Test
    void testInvalidDescription() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(validTaskID, validName, "Illegal Task Description that is way way way way toooooooooooo long");
        });
    }

    @Test
    void testNullTaskID() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, validName, validDescription);
        });
    }

    @Test
    void testNullName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(validTaskID, null, validDescription);
        });
    }

    @Test
    void testNullDescription() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(validTaskID, validName, null);
        });
    }
}
