package me.markrose.example;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import me.markrose.example.TaskService.TaskRequest;

public class TaskClient {

    private static final String SERVER_HOST = "localhost";

    public void run() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(SERVER_HOST,
                TaskService.RMI_PORT);
        TaskService service = (TaskService) registry
                .lookup(TaskService.SERVICE_NAME);
        TaskRequest request = new TaskRequest("sample task");
        System.out.println("[client] About to request task: " + request);
        boolean result = service.createTask(request);
        System.out.println("[client] Result: " + result);
    }

    public static void main(String[] args)
            throws RemoteException, NotBoundException {
        new TaskClient().run();
    }

}
