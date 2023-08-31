package org.example;

//public class TestFlatMap {
//}
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    private int id;
    private String name;
    private String city;

    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}

public class TestFlatMap {
    public static void main(String[] args) {
        List<Employee> al = new ArrayList<>();
        al.add(new Employee(101, "Pradeep Kumar", "Mumbai"));
        al.add(new Employee(102, "Rahul Kumar", "Delhi"));
        al.add(new Employee(103, "Saurabh Kumar", "Mumbai"));

        List<String> newList = al.stream()
                .filter(x -> x.getCity().equals("Mumbai"))
                .flatMap(e -> Stream.of(e.getCity()))
                .collect(Collectors.toList());

        System.out.println(newList);
    }
}

