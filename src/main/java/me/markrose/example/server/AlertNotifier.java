package me.markrose.example.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import me.markrose.example.services.AlertHandler;
import me.markrose.example.services.AlertInfo;
import me.markrose.example.services.AlertService;

/**
 * Implements a service to subscribe to alerts.
 */
public class AlertNotifier implements AlertService {

    private List<AlertHandler> handlers = new ArrayList<>();

    @Override
    public synchronized void addAlertHandler(AlertHandler handler) {
        if (!handlers.contains(handler)) {
            handlers.add(handler);
        }
    }

    /**
     * Sends an alert to all handlers.
     *
     * @param info the alert info
     */
    public synchronized void sendAlert(AlertInfo info) {
        ListIterator<AlertHandler> it = handlers.listIterator();
        while (it.hasNext()) {
            AlertHandler handler = it.next();
            try {
                handler.handlerAlert(info);
            } catch (RemoteException e) {
                System.err.println(
                        "[server] Error while trying to send alert to client - removing handler");
                it.remove();
            }
        }
    }

}
