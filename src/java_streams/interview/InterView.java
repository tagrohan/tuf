package java_streams.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterView {

    public static void main(String[] args) {
        seperateEvenOdd();

    }

    private static void printSumOfArray() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        Integer reduce = list.stream()
                .reduce(0, Integer::sum);

//        Optional<Integer> reduceOptional = list.stream()
//                .reduce(Integer::sum);

        System.out.println(reduce);
    }

    private static void averageOfNumber() {
        // 15 / 5  = 3
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        double v = list.stream()
                .mapToInt(Integer::intValue) // .map(e -> e) means as it is
                .average()
                .orElse(0); // Double.NaN
        System.out.println(v);

    }

    private static void squareThenFilterThenGetAverageOfThoseNumbers() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // most optimised one
        double av = list.stream()
                .mapToInt(i -> i * i)
                .filter(i -> i < 10).average().orElse(0);

        System.out.println(av);
        System.out.println(list);

        double average = list.stream()
                .map(i -> i * i)
                .filter(i -> i < 10)
                .mapToInt(Integer::intValue).average().orElse(0);

        System.out.println(average);

        int inte = (int) list.stream()
                .map(i -> i * i)
                .filter(i -> i < 10)
                .mapToInt(Integer::intValue).average().orElse(0);

        System.out.println(inte);


    }

    private static void seperateEvenOdd() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = Stream.concat( // concat is the catch here
                list.stream().filter(i -> i % 2 == 0),  // Even numbers
                list.stream().filter(i -> i % 2 != 0)   // Odd numbers
        ).collect(Collectors.toList());

        System.out.println(result);
    }
}

