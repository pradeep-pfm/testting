package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test8 {
    public static void main(String[] args) {


        List<Employee> al = new ArrayList<>();
        al.add(new Employee(101, "Pradeep Kumar", 28, "IT", 2020, 85000,"Male"));
        al.add(new Employee(102, "Khushdeep Yadav", 3, "HR", 2020, 55000,"Female"));
        al.add(new Employee(103, "Rahul Yadav", 22, "QA", 2018, 65000,"Male"));
        al.add(new Employee(104, "Khushaboo Yadav", 28, "HR", 2021, 85000,"Female"));
        al.add(new Employee(105, "Lucky Yadav", 19, "IT", 2020, 65000,"Male"));
        al.add(new Employee(103, "Badal Yadav", 18, "QA", 2020, 45000,"Male"));
       // System.out.println(al);
        //        Map<String,String> newMap=al.stream()
//                .filter(x->x.getName().startsWith("K") && x.getGender().equals("Female"))
//                .collect(Collectors.toMap(Employee::getName,Employee::getGender));
//        //System.out.println(newMap);
//        Map<String,Integer> dup=al.stream()
//                .filter(x->x.getAge()>=28)
//                //.filter(x->x.getName().startsWith("K") && x.getGender().equals("Female"))
//                .collect(Collectors.toMap(Employee::getName,Employee::getAge));
//        //System.out.println(dup);
//        List<Employee> topSal=al.stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary)
//                        .reversed())
//                .limit(1)
//                .collect(Collectors.toList());
//        System.out.println("Highest salary : "+topSal);
        List<String> departmentList=al.stream()
                .filter(x->x.getDepartment().equals("IT"))
                .flatMap(x-> Stream.of(x.getDepartment()))
                .collect(Collectors.toList());
        System.out.println(departmentList);

           Set<String> newList=al.stream()
          .map(Employee::getName).collect(Collectors.toSet());
           System.out.println(newList);

        List<String> fltmap=al.stream()
                .filter(y->y.getDepartment().equals("IT"))
                .flatMap(x->Stream.of(x.getDepartment()))
                .collect(Collectors.toList());


    }


}