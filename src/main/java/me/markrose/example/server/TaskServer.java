package me.markrose.example.server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import me.markrose.example.services.AlertService;
import me.markrose.example.services.TaskCreator;

/**
 * Implements the boiler-plate code required to instantiate a server-side
 * service provider and bind it in the RMI registry. The service provider will
 * automatically wait until requests come in.
 */
public class TaskServer {

    public static final int RMI_PORT = 1999;

    /**
     * Creates an RMI registry and a service provider, and binds the service
     * provider in the RMI registry. The RMI server will automatically run and
     * wait for requests to pass on to the service provider.
     *
     * @param args the command-line arguments
     * @throws RemoteException if there is a communication error
     * @throws NotBoundException
     */
    public static void main(String[] args)
            throws RemoteException, NotBoundException {

        // Create an RMI registry.
        Registry registry = LocateRegistry.createRegistry(RMI_PORT);

        // Create the alert notifier and bind it as the alert service.
        AlertNotifier alertNotifier = new AlertNotifier();
        AlertService alertStub = (AlertService) UnicastRemoteObject
                .exportObject(alertNotifier, 0);
        registry.rebind(AlertService.SERVICE_NAME, alertStub);
        System.out.println("[server] AlertService bound");

        // Create the task creator service and bind it so it is available
        // remotely.
        TaskCreatorImpl taskCreator = new TaskCreatorImpl(alertNotifier);
        TaskCreator taskStub = (TaskCreator) UnicastRemoteObject
                .exportObject(taskCreator, 0);
        registry.rebind(TaskCreator.SERVICE_NAME, taskStub);
        System.out.println("[server] TaskService bound");
    }

}
