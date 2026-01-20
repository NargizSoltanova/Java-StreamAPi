import entities.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        //Task 1
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        var evenList = list.stream().filter(e -> e % 2 == 0).toList();
        System.out.println(evenList);

        //Task 2
        List<String> names = List.of("java","stream","api");
        var upperCaseNames = names.stream().map(String::toUpperCase).toList();
        System.out.println(upperCaseNames);

        //Task 3
        List<Integer> nums = List.of(5,10,15,20);
        var countGreaterTen = nums.stream().filter(x -> x > 10).count();
        System.out.println(countGreaterTen);

        //Task 4
        List<String> data = Arrays.asList("A",null,"B",null,"C");
        var nonNullList = data.stream().filter(Objects::nonNull).toList();
        System.out.println(nonNullList);

        //Task 5
        List<String> namesList = List.of("Bob","Alice","Andrew","Charlie");
        var firstName = namesList.stream()
                .filter(x -> x.startsWith("A"))
                .findFirst().orElse(null);
        System.out.println(firstName);

        //Task 6
        List<Integer> numbers = List.of(3,1,4,2);
        var sortedAndSquaredList = numbers.stream()
                .map(x -> x * x)
                .sorted().toList();
        System.out.println(sortedAndSquaredList);

        //Task 7
        List<Integer> numbersList = List.of(1,2,3,4,5,6);
        var sumOfEvenNumbers = numbersList.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println(sumOfEvenNumbers);

        //Task 8
        List<String> words = List.of("apple","banana","kiwi");
        Map<String,Integer> mapList = words.stream()
                .collect(Collectors.toMap(Function.identity(), String :: length));
        System.out.println(mapList);

        //Task 9
        List<Integer> numbers2 = List.of(10,50,30);
        var maxNumber = numbers2.stream().max(Integer::compareTo).orElse(0);
        System.out.println(maxNumber);

        //Task 10
        List<String> wordsList = List.of("a","bb","ccc","dd");
        Map<Integer, List<String>> wordsMap = wordsList.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(wordsMap);

        //Task 11
        List<Integer> numbers3 = List.of(1,2,3,4,5);
        Map<Boolean, List<Integer>> partitionNumbers = numbers3.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(partitionNumbers);

        //Task 12
        List<Integer> numbers4 = List.of(1,2,3,2,4,3,5);
        Set<Integer> seen = new HashSet<>();
        var duplicates = numbers4.stream()
                .filter(x -> !seen.add(x))
                .toList();
        System.out.println(duplicates);

        //Task 13 with 2 method
        List<List<String>> listDouble= List.of(
                List.of("A","B"),
                List.of("C","D")
        );

        var flattenList = listDouble.stream()
                .flatMap(List :: stream)
                .toList();
        System.out.println(flattenList);

        var mapMulti = listDouble.stream()
                .mapMulti(Iterable::forEach)
                .toList();
        System.out.println(mapMulti);

        //Task 14
        var employeeList = new ArrayList<Employee>(){
            {
                add(new Employee("John Doe", 3000.0));
                add(new Employee("Maria", 2000.0));
            }
        };
        var sortedList = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .toList();
        System.out.println(sortedList);

        //Task 15
        var findAverageSalary = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(findAverageSalary);

        //Task 16
        List<String> names2 = List.of("A","B","C");
        names2.stream().forEach(System.out::println);

        //Task 17
        List<Integer> numbers5 = List.of(1,4,6,8,2);
        var filteredNumbers = numbers5.stream().filter(x -> x > 5).toList();
        System.out.println(filteredNumbers);

        //Task 18
        List<Integer> numbers6 = List.of(1,2,3);
        var multipleNumbers = numbers6.stream()
                .mapToInt(x -> x * 2).boxed().toList();
        System.out.println(multipleNumbers);

        //Task 19
        List<String> words3 = List.of("java","stream");
        Map<String,Integer> lengthEachString = words3.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(lengthEachString);

        //Task 20
        List<Integer> numbers7 = List.of(1,3,5,6);
        Boolean anyEven =  numbers7.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(anyEven);

    }
}
