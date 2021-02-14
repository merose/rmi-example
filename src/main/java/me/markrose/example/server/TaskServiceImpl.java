package me.markrose.example.server;

import java.rmi.RemoteException;
import me.markrose.example.services.TaskService;
import me.markrose.example.services.TaskService.TaskRequest;

/**
 * Implements the server side of the service provider, allowing clients to
 * request that tasks be created.
 */
public class TaskServiceImpl implements TaskService {

    @Override
    public boolean createTask(TaskRequest request) throws RemoteException {
        System.out.println(
                "[server] Got request for task: " + request.getName());
        return true;
    }

}
