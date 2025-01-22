package java_streams;

import java.util.Arrays;
import java.util.List;

public class TerminationOperations {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 3, 41, 6, 5, 7);

        Integer[] array =  integers.stream()
                .filter(i -> i > 2)
                .toArray(Integer[]::new);
    }
}
