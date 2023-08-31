package org.example;

import java.util.stream.IntStream;

public class Parrall {

    public static void main(String[] args) {
        long start=0;
        long end=0;

//        IntStream.range(0,100000).forEach(x->{
//                    System.out.println("Thread :: "+Thread.currentThread().getName()+"--"+x);
//                });
        start=System.currentTimeMillis();
        IntStream.range(0,100).forEach(System.out::println);
        end=System.currentTimeMillis();

        System.out.println("Plain stream took time :: "+(end-start));

        start=System.currentTimeMillis();
        IntStream.range(0,100).parallel().forEach(System.out::println);
        end=System.currentTimeMillis();
        System.out.println("Parrallel stream took time :: "+(end-start));

    }
}
