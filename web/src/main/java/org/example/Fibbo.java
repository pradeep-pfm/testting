package org.example;

import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Fibbo {
    public static List<Integer> getFibboSeries(Integer series){
        return Stream.iterate(new int[]{0,1}, m->new int[]{m[1],m[0]+m[1]})
                .limit(series)
                .map(n->n[0])
                .collect(toList());

    };
    public static void main(String[] args) {
       List<Integer> fi= getFibboSeries(20);
       fi.forEach(x-> System.out.println(x));

    }
}
