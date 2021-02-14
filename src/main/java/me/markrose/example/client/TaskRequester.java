package me.markrose.example.client;

import java.rmi.RemoteException;
import me.markrose.example.services.TaskCreator;
import me.markrose.example.services.TaskRequest;

/**
 * Implements the portion of the client code that requests tasks be performed.
 */
public class TaskRequester implements Runnable {

    private String[] TASK_NAMES = { "importModels", "receiveData",
            "processData" };

    private TaskCreator service;

    private int nextTaskIndex = 0;

    /**
     * Creates a new instance of a task requesting entity, which uses a given
     * service provider object to request tasks. Note that the client generally
     * does not care whether the service provider is local or remote, except
     * that {@link RemoteException} may be thrown by remote methods.
     *
     * @param service the service provider
     */
    public TaskRequester(TaskCreator service) {
        this.service = service;

    }

    /**
     * Requests a task be created on the service provider.
     */
    @Override
    public void run() {
        for (;;) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // ignore
            }

            // Create the next task request.
            TaskRequest request = new TaskRequest(TASK_NAMES[nextTaskIndex]);
            nextTaskIndex = (nextTaskIndex + 1) % TASK_NAMES.length;

            // Request the task.
            System.out.println(
                    "[client] About to request task: " + request.getName());
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

}
