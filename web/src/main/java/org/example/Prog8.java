package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Prog8 {
    public static void main(String[] args) {
        //count number of char occurence in string
        String input = "microservices";
//      Map<String, Long> map=Arrays.stream(input.split(""))
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        System.out.println(map);
//    }
        /// Find duplicate element in Array

//   List<String> duplicate= Arrays.stream(input.split(""))
//          .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//          .entrySet().stream()
//          .filter(x->x.getValue()>1)
//          .map(Map.Entry::getKey)
//          .collect(Collectors.toList());
//        System.out.println(duplicate);
        //}
        ///// Find first non-repeatative element in Array
//     String unique=   Arrays.stream(input.split(""))
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(x->x.getValue()==1)
//                .findFirst().get().getKey();
//        System.out.println(unique);
//    }
  int[] numbers={3,5,9,11,6,10,21,2};
  Integer second=Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println(second);
    }
}