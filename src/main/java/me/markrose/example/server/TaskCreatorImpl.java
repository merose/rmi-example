package me.markrose.example.server;

import java.rmi.RemoteException;
import me.markrose.example.services.TaskCreator;
import me.markrose.example.services.TaskRequest;

/**
 * Implements the server side of the service provider, allowing clients to
 * request that tasks be created.
 */
public class TaskCreatorImpl implements TaskCreator {

    private AlertNotifier alertNotifier;

    public TaskCreatorImpl(AlertNotifier alertSender) {
        this.alertNotifier = alertSender;
    }

    @Override
    public boolean createTask(TaskRequest request) throws RemoteException {
        System.out.println(
                "[server] Got request for task: " + request.getName());

        // Duration is between 2 and 5 seconds.
        long durationMillis = (long) (2000 + 4000 * Math.random());
        Thread taskThread = new Thread(
                new Task(request.getName(), durationMillis, alertNotifier));
        taskThread.start();

        return true;
    }

}
