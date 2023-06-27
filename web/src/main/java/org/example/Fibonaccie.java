package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonaccie {

   public static List<Integer> getFibo(int number){
       return Stream.iterate(new int[]{0,1}, m-> new int[]{m[1],m[0]+m[1]})
               .limit(number)
               .map(n->n[0])
               .collect(toList());

    }
    public static void main(String[] args) {
       List<Integer> fib=getFibo(10);
               fib.forEach(x-> System.out.println(x));


    }
}
