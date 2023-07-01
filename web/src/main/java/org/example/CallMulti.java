package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallMulti implements Callable
{
    String name;
    CallMulti(String name){
        this.name=name;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(name + "...Jobs started by Thread:" + Thread.currentThread().getName());
        return name;

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
            // Future r=service.wait();
            }
            service.shutdown();
        }
    }

}
