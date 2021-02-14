package me.markrose.example.client;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import me.markrose.example.server.TaskServer;
import me.markrose.example.services.AlertHandler;
import me.markrose.example.services.AlertService;
import me.markrose.example.services.TaskCreator;

/**
 * Implements the client-side boiler-plate code required to connect to a remote
 * service provider, then invokes the task requester client to use that service
 * provider.
 */
public class TaskClient {

    /**
     * Locates a remote service provider and invokes the client code to request
     * task creation.
     *
     * @param args the command-line arguments
     * @throws RemoteException if there is a communication exception
     * @throws NotBoundException if there is no server bound in the registry
     * @throws AlreadyBoundException
     */
    public static void main(String[] args)
            throws RemoteException, NotBoundException {

        if (args.length != 1) {
            System.err.println("Usage: java TaskClient serverHost");
            System.exit(1);
        }

        // Get the RMI registry.
        String serverHost = args[0];
        Registry registry = LocateRegistry.getRegistry(serverHost,
                TaskServer.RMI_PORT);

        // Find the task creator service and the alert service.
        TaskCreator taskService = (TaskCreator) registry
                .lookup(TaskCreator.SERVICE_NAME);
        AlertService alertService = (AlertService) registry
                .lookup(AlertService.SERVICE_NAME);

        // Create the alert handler and register it with the alert service.
        AlertHandler alertStub = (AlertHandler) UnicastRemoteObject
                .exportObject(new AlertHandlerImpl(), 0);
        alertService.addAlertHandler(alertStub);

        // Create and run the task requester thread.
        Thread thread = new Thread(new TaskRequester(taskService));
        thread.start();
    }

}
