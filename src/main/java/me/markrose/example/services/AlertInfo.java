package me.markrose.example.services;

import java.io.Serializable;

/**
 * Holds the details about an alert.
 */
public class AlertInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    /**
     * Creates a new alert instance with a given alert message.
     *
     * @param message the alert message
     */
    public AlertInfo(String message) {
        this.message = message;
    }

    /**
     * Gets the alert message.
     *
     * @return the alert message
     */
    public String getMessage() {
        return message;
    }

}
