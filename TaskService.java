package Task;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class TaskService {

    private static List<Task> taskList = new ArrayList<Task>();

    // ID to assign to incoming tasks
    private static int currID = 0;

    public static void clearList() {
        taskList.clear();
        currID = 0;
    }

    public static int sizeOfList() {
        return taskList.size();
    }

    /**
     * Adds a new task to the taskList using a generated taskID
     * @param name
     * @param description
     */
    public static void addTask(String name, String description) {
        // convert currID to string to assign to the task being added
        String strID = Integer.toString(currID);
        Task task = new Task(strID, name, description);
        taskList.add(task);
        // increment currID so the next task has another unique ID
        currID += 1;
    }

    /**
     * Find a task in the private task list using its ID,
     * throws an ElementNotFoundException if no task is found
     * @param targetID
     */
    public static Task getTask(String targetID) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTaskID().equals(targetID)) {
                return taskList.get(i);
            }
        }
        throw new NoSuchElementException("No matching task");
    }

    /**
     * Delete a task using the taskID
     * @param targetID
     */
    public static void deleteTaskByID(String targetID) {
        try {
            Task task = getTask(targetID);
            taskList.remove(task);
        } catch (Exception e) {
        }
    }

    /**
     * Updates a task's name using the taskID
     * @param targetID
     * @param name
     */
    public static void updateNameByID(String targetID, String name) {
        try {
            Task task = getTask(targetID);
            task.setName(name);
        } catch (Exception e) {
        }
    }

    /**
     * Updates a task's description using the taskID
     * @param targetID
     * @param description
     */
    public static void updateDescriptionByID(String targetID, String description) {
        try {
            Task task = getTask(targetID);
            task.setDescription(description);
        } catch (Exception e) {
        }
    }
}
