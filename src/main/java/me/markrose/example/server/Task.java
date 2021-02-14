package me.markrose.example.server;

import me.markrose.example.services.AlertInfo;

/**
 * Implements a dummy task. The task just delays for a defined amount of time.
 * It also generates alerts at the start and end of the task.
 */
public class Task implements Runnable {

    private String name;
    private long durationMillis;
    private AlertNotifier alertNotifier;

    public Task(String name, long durationMillis,
            AlertNotifier alertService) {

        this.name = name;
        this.durationMillis = durationMillis;
        this.alertNotifier = alertService;
    }

    @Override
    public void run() {
        alertNotifier.sendAlert(new AlertInfo("Task " + name + " started"));

        // Do the task (but here we just delay.
        try {
            Thread.sleep(durationMillis);
        } catch (InterruptedException e) {
            // ignore
        }

        alertNotifier.sendAlert(new AlertInfo("Task " + name + " completed"));
    }

}