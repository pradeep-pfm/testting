package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Prog8 {
    public static void main(String[] args) {
        //count number of char occurence in string
   /*     String input = "microservices";
     Map<String, Long> map=Arrays.stream(input.split(""))
               .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       System.out.println(map);
   }*/
        /// Find duplicate element in Array

//   List<String> duplicate= Arrays.stream(input.split(""))
//          .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//          .entrySet().stream()
//          .filter(x->x.getValue()>1)
//          .map(Map.Entry::getKey)
//          .collect(Collectors.toList());
//        System.out.println(duplicate);
        //}
        ///// Find first non-repetitive element in Array
        String input = "microservices for best practice z ";
     String unique=   Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue()==1)
                .findFirst().get().getKey();
        System.out.println("Unique element are "+unique);
//    }
  int[] numbers={3,5,9,11,6,10,21,2};
  Integer second=Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();

         System.out.println("new list are :"+second);
        int[] numbers2={3,5,9,11,6,10,21,2};
        Integer sec1= Arrays.stream(numbers2).boxed()
                .sorted()
                .skip(1)
                .findFirst().get();
        System.out.println(sec1);

    }
}