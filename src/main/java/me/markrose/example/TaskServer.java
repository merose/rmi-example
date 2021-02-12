package me.markrose.example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TaskServer implements TaskService {

    public void run() throws RemoteException {
        TaskService stub = (TaskService) UnicastRemoteObject.exportObject(this,
                0);
        Registry registry = LocateRegistry
                .createRegistry(TaskService.RMI_PORT);
        registry.rebind(TaskService.SERVICE_NAME, stub);
        System.out.println("[server] TaskService bound");
    }

    @Override
    public boolean createTask(TaskRequest request) throws RemoteException {
        System.out.println(
                "[server] Got request for task: " + request.getName());
        return true;
    }

    public static void main(String[] args) throws RemoteException {
        new TaskServer().run();
    }

}
