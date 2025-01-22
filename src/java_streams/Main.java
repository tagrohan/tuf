package java_streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

    }

    private static void sortEmployee() {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        // Generate 10 employees with random names and salaries between 1 and 100
        for (int i = 0; i < 5; i++) {
            String name = "Employee_" + (i + 1);
            int salary = random.nextInt(100) + 1; // Generate random salary between 1 and 100 (inclusive)
            employees.add(new Employee(name, salary));
        }

        employees.forEach(System.out::println);

        List<String> names = employees.stream()
                .filter(e -> e.getSalary() > 10)
                .sorted(Comparator.comparingDouble(Employee::getSalary)) // .reverse() to reverse it
//                .sorted((o1, o2) -> o1.getSalary() - o2.getSalary()) // this also works
//                .sorted((o1, o2) -> Integer.compare(o1.getSalary(), o2.getSalary())) // another way of doing it and u can revese this by changind o1 and o2
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
