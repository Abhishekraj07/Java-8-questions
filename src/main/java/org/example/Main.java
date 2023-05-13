package org.example;

import java.util.*;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String s="abhabhabhaylcd";

        /// Programe to find the count

        Map<String, Long> collect = Arrays.stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        System.out.println("First");

        /// Programe to find the not distinct letters

        Arrays.stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
                .filter(p->p.getValue()>1)
                .forEach(p-> System.out.println(p.getKey()));
        System.out.println("sec");

        /// Programe to find the  distinct letters

        Arrays.stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
                .filter(p->p.getValue()==1)
                .forEach(p-> System.out.println(p.getKey()));
        System.out.println("3rd");

        /// Programe to find the first non-repeat element
        List<Map.Entry<String, Long>> first1 = Arrays.stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                .filter(p -> p.getValue() == 1)
                .toList().stream().toList();


        System.out.println("########");

        List<String> x = Arrays.stream(s.split("")).filter( chr -> Arrays.stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).get(chr) == 1).findFirst().stream().toList();

        System.out.println(x);

        List<String> collect2 = Arrays.stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .filter(p -> p.getValue() == 1)
                .toList().stream().toList().stream().map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println("_________");
        System.out.println(collect2);


        Optional<String> first = Arrays.stream(s.split("")).filter(p -> s.indexOf(p) == s.lastIndexOf(p)).toList().stream().findFirst();
        System.out.println("_________eq");
        System.out.println(first.orElse("not found"));

        List<String> collect1 = Arrays.stream(s.split("")).
                collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                .filter(p -> p.getValue() == 1)
                .toList().stream().toList().stream().map(Map.Entry::getKey).collect(Collectors.toList());


        ///find second highest num in an array

        List<Integer>listVal = Arrays.asList(1,4,2,5);
        // ans 4
        //Comparator<Integer> newVal = Comparator.comparingInt(listVal);

        //List<Integer> collect3 = listVal.stream().filter(Collectors.maxBy(Comparator.comparing())).collect(Collectors.toList());

        Integer first2 = listVal.stream().sorted(Comparator.reverseOrder()).skip(1).collect(Collectors.toList()).stream().findFirst().get();
        System.out.println("-----");
        System.out.println(first2);
        
        /// java programe to find the longest string from an array
        
        List<String> stringRes = Arrays.asList("azaaaaaaaaaa", "azaaaaaaaaab","ads","asdasdas");

        //stringres.stream().collect(Collectors.toMap(String::length, Function.identity()))
//                .entrySet().stream().map(p->p.getValue())
//                .collect(Collectors.toList())
//                .stream().sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList()).stream().findFirst().get();

//        String k = stringRes.stream()
//                .collect(Collectors.toMap(
//                        String::length,
//                        Function.identity(),
//                        (value1, value2) -> value1,
//                        () -> new TreeMap<>(Comparator.comparing(String::length)
//                                .thenComparing(Comparator.naturalOrder()))
//                )).firstEntry().getValue();
//        System.out.println(k);


        Map.Entry<String, Integer> k = stringRes.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (value1, value2) -> value1,
                        () -> new TreeMap<>(Comparator.comparing(String::length, Comparator.reverseOrder())
                                .thenComparing(Comparator.naturalOrder()))
                )).firstEntry();

        System.out.println(k);


//        String sorted = stringRes.stream().collect(Collectors.toMap(String::length, Function.identity()))
//                .entrySet().stream().map(p->p.getValue())
//                .collect(Collectors.toList())
//                .stream().sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList()).stream().findFirst().get();
//        System.out.println(sorted);

        /// Java program to print the number starting with 1

        List<Integer> valueInt = Arrays.asList(11,3,22,4,111,234);
        List<Integer> collect3 = valueInt.stream()
                .filter(p -> String.valueOf(p).startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(collect3);

    }

}
