package me.markrose.example.services;

import java.io.Serializable;

/**
 * Defines an interface task requests must implement.
 */
public class TaskRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String taskName;

    /**
     * Creates a new request with a given name.
     *
     * @param name the task name
     */
    public TaskRequest(String name) {
        taskName = name;
    }

    /**
     * Gets the task name.
     *
     * @return the task name
     */
    public String getName() {
        return taskName;
    }

    @Override
    public String toString() {
        return "TaskRequest [taskName=" + taskName + "]";
    }

}