package com.threadExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorDemo {

    public static void main(String[] args) {
        // Create a fixed thread pool with 4 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        for (int jobId = 0; jobId <= 7; jobId++) {
            int currentJob = jobId;
            threadPool.submit(() -> {

                System.out.println("Job " + currentJob + " is being executed by " + Thread.currentThread().getName());

                try {
                    Thread.sleep(3000); // Simulate a delay for each task
                } catch (InterruptedException exception) {
                    System.out.println("Job " + currentJob + " was interrupted");
                }
                System.out.println("Job " + currentJob + " is completed by " + Thread.currentThread().getName());
            });
        }

        threadPool.shutdown();
        System.out.println("All jobs have been submitted");
    }
}
