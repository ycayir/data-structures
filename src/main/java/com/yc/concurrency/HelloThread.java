package com.yc.concurrency;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from Hello Thread!");
    }

    public static void main(String[] args) {
        (new HelloThread()).start();
    }
}
