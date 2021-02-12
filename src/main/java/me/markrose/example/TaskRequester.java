package me.markrose.example;

import java.rmi.RemoteException;
import me.markrose.example.TaskService.TaskRequest;

/**
 * Implements the portion of the client code that requests tasks be performed.
 */
public class TaskRequester implements Runnable {

    private TaskService service;

    /**
     * Creates a new instance of a task requesting entity, which uses a given
     * service provider object to request tasks. Note that the client generally
     * does not care whether the service provider is local or remote, except
     * that {@link RemoteException} may be thrown by remote methods.
     *
     * @param service the service provider
     */
    public TaskRequester(TaskService service) {
        this.service = service;

    }

    /**
     * Requests a task be created on the service provider.
     */
    @Override
    public void run() {
        TaskRequest request = new TaskRequest("sample task");
        System.out.println("[client] About to request task: " + request);
        try {
            boolean result = service.createTask(request);
            System.out.println("[client] Result: " + result);
        } catch (RemoteException e) {
            System.err.println(
                    "[client] Exception while trying to request a task: "
                            + e.getMessage());
            e.printStackTrace();
        }
    }


}
