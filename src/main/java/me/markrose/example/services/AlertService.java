package me.markrose.example.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Implements a service that allows a client to subscribe to alerts.
 */
public interface AlertService extends Remote {

    String SERVICE_NAME = "alertService";

    /**
     * Adds a new client alert handler.
     *
     * @param handler the alert handler
     */
    void addAlertHandler(AlertHandler handler) throws RemoteException;

}
