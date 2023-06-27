package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintJob implements Runnable {
    String name;

    PrintJob(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        System.out.println(name + "...Jobs started by Thread:" + Thread.currentThread().getName());
        System.out.println("===================================");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + "..jobs completed by Thread: " + Thread.currentThread().getName());
    }
}

    class ExecutorDemo {
        public static void main(String[] args) {
            PrintJob[] jobs = {new PrintJob("Pradeep"),
                    new PrintJob("Pradeep"),
                    new PrintJob("Kumar"),
                    new PrintJob("Khushdeep"),
                    new PrintJob("Prakhush"),
                    new PrintJob("Khooshaboo"),
                    new PrintJob("Yadav"),
                    new PrintJob("Jaunpur")
            };
            ExecutorService service = Executors.newFixedThreadPool(6);
            for (PrintJob job : jobs) {
                service.submit(job);
            }
            service.shutdown();
        }
    }

