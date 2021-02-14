package me.markrose.example.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Defines the methods of an alert handler.
 */
public interface AlertHandler extends Remote {

    String SERVICE_NAME = "alertHandler";

    /**
     * Handles an alert.
     *
     * @param info the alert details
     */
    void handlerAlert(AlertInfo info) throws RemoteException;

}
