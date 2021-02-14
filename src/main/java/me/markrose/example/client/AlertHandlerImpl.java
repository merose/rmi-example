package me.markrose.example.client;

import me.markrose.example.services.AlertHandler;
import me.markrose.example.services.AlertInfo;

/**
 * Implements an alert handler that displays alerts to the console. In a GUI
 * application this might update the GUI.
 */
public class AlertHandlerImpl implements AlertHandler {

    @Override
    public void handlerAlert(AlertInfo info) {
        System.out.println(
                "[client] Received alert with message: " + info.getMessage());
    }

}
