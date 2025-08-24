package Task;

public class Task {

    private String taskID;
    private String name;
    private String description;

    /**
     * Validates taskID
     * @param taskID
     * @return boolean
     */
    private Boolean validateTaskID(String taskID) {
        if (taskID == null || taskID.length() > 10) {
            return false;
        }
        return true;
    }

    /**
     * Validates task name
     * @param name
     * @return boolean
     */
    private Boolean validateName(String name) {
        if (name == null || name.length() > 20) {
            return false;
        }
        return true;
    }

    /**
     * Validates task description
     * @param description
     * @return boolean
     */
    private Boolean validateDescription(String description) {
        if (description == null || description.length() > 50) {
            return false;
        }
        return true;
    }

    public Task(String taskID, String name, String description) {
        if (!this.validateTaskID(taskID)) {
            throw new IllegalArgumentException("Invalid task ID");
        }

        if (!this.validateName(name)) {
            throw new IllegalArgumentException("Invalid task name");
        }

        if (!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    // Getters and setters
    // taskID only has a getter, it is not updatable
    public String getTaskID() {
        return this.taskID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("Invalid task name");
        }
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (!validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
