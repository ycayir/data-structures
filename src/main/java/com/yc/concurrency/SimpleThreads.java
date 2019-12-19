package com.yc.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class SimpleThreads {

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private class MessageLoop {

    }

    public static void main(String[] args) {
        long patience = 1000 * 60 * 60;

        // assuming that command line argument as in seconds
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop ");

    }
}
