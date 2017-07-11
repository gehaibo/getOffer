package javaBase.Lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Jackson on 2017/7/8.
 */
public class StreamTest {
    public static void main(String[] args) {
        //构造流的方式
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

        //数值流的构造
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        // 1. Array
        String[] strArray1 = (String[]) stream.toArray(String[]::new);
        // 2. Collection
        List<String> list1 = (List<String>) stream.collect(Collectors.toList());
        List<String> list2 = (List<String>) stream.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = (Set) stream.collect(Collectors.toSet());
        Stack stack1 = (Stack) stream.collect(Collectors.toCollection(Stack::new));
        // 3. String
        String str = stream.collect(Collectors.joining()).toString();

    }
}
