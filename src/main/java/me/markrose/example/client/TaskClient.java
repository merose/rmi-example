package me.markrose.example.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import me.markrose.example.services.TaskService;

/**
 * Implements the client-side boiler-plate code required to connect to a remote
 * service provider, then invokes the task requester client to use that service
 * provider.
 */
public class TaskClient {

    private static final String SERVER_HOST = "localhost";

    /**
     * Locates a remote service provider and invokes the client code to request
     * task creation.
     *
     * @param args the command-line arguments
     * @throws RemoteException if there is a communication exception
     * @throws NotBoundException if there is no server bound in the registry
     */
    public static void main(String[] args)
            throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry(SERVER_HOST,
                TaskService.RMI_PORT);
        TaskService service = (TaskService) registry
                .lookup(TaskService.SERVICE_NAME);

        TaskRequester requester = new TaskRequester(service);

        // Perform the client task requesting code.
        requester.run();
    }

}
