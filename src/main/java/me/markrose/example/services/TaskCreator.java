package me.markrose.example.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Defines the methods of a task creator service.
 */
public interface TaskCreator extends Remote {

    String SERVICE_NAME = "taskService";

    /**
     * Requests to create a task on the server.
     *
     * @param request the task request
     * @return true, if the task was successfully requested
     * @throws RemoteException if there is an error transmissing the request
     */
    boolean createTask(TaskRequest request) throws RemoteException;

}
