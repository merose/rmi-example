package me.markrose.example.services;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Defines an interface as task service server must implement.
 */
public interface TaskService extends Remote {

    int RMI_PORT = 1999;
    String SERVICE_NAME = "taskService";

    /**
     * Requests to create a task on the server.
     *
     * @param request the task request
     * @return true, if the task was successfully requested
     * @throws RemoteException if there is an error transmissing the request
     */
    boolean createTask(TaskRequest request) throws RemoteException;

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

        public String getName() {
            return taskName;
        }

    }

}
