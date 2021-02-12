package me.markrose.example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implements the boiler-plate code required to instantiate a server-side
 * service provider and bind it in the RMI registry. The service provider will
 * automatically wait until requests come in.
 */
public class TaskServer {

    /**
     * Creates an RMI registry and a service provider, and binds the service
     * provider in the RMI registry. The RMI server will automatically run and
     * wait for requests to pass on to the service provider.
     *
     * @param args the command-line arguments
     * @throws RemoteException if there is a communication error
     */
    public static void main(String[] args) throws RemoteException {
        TaskServiceImpl server = new TaskServiceImpl();
        TaskService stub = (TaskService) UnicastRemoteObject.exportObject(
                server,
                0);
        Registry registry = LocateRegistry
                .createRegistry(TaskService.RMI_PORT);
        registry.rebind(TaskService.SERVICE_NAME, stub);
        System.out.println("[server] TaskService bound");
    }

}
