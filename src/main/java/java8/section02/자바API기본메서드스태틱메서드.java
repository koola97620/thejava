package java8.section02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class 자바API기본메서드스태틱메서드 {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

//        name.forEach(System.out::println);
//        Spliterator<String> spliterator1 = name.spliterator();
//        Spliterator<String> spliterator2 = spliterator1.trySplit();
//
//        while(spliterator1.tryAdvance(System.out::println));
//        System.out.println("--------------");
//        while(spliterator2.tryAdvance(System.out::println));

//        List<String> k = name.stream().map(String::toUpperCase)
//                .filter(s -> s.startsWith("K"))
//                //.count();
//                .collect(Collectors.toList());
//        System.out.println(k);


//        name.removeIf(s -> s.startsWith("k"));
//        name.forEach(System.out::println);

//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//        name.sort(compareToIgnoreCase.reversed());


    }
}
