package com.yc.concurrency;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.print("Hello from Hello Runnable!");
    }

    public static void main(String[] args) {
        (new Thread(new HelloRunnable())).start();
    }
}
