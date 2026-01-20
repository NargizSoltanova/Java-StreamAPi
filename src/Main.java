import entities.Employee;

import java.awt.print.Book;
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

        //Task 21
        List<Integer> numbers8 = List.of(1,2,3, -1);
        Boolean checkAllPositive = numbers8.stream().allMatch(x -> x > 0);
        System.out.println(checkAllPositive);

        //Task 22
        List<Integer> numbers9 = List.of(1,2,3);
        Boolean checkNoIsNegative = numbers9.stream().noneMatch(x -> x < 0);
        System.out.println(checkNoIsNegative);

        //Task 23
        List<String> names3 = List.of("Banana","Apple","Mango");
        var sortedList3 = names3.stream().sorted().toList();
        System.out.println(sortedList3);

        //Task 24
        List<Integer> numbers10 = List.of(4,1,7,2);
        var sortedList10 = numbers10.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedList10);

        //Task 25
        List<Integer> numbers11 = List.of(9,3,6);
        var min =  numbers11.stream().min(Integer::compareTo).orElse(0);
        System.out.println(min);

        //Task 26
        List<String> names4 = List.of("Java","Python","C++");
        var first = names4.stream().findFirst().orElse(null);
        System.out.println(first);

        //Task 27
        List<Integer> numbers12 = List.of(1,2,3,4,5);
        var skip2element =  numbers12.stream().skip(2).toList();
        System.out.println(skip2element);

        //Task 28
        List<Integer> numbers13 = List.of(10,20,30,40,50);
        var limit3element =  numbers13.stream().limit(3).toList();
        System.out.println(limit3element);

        //Task 29
        List<Integer> numbers14 = List.of(1,2,2,3,3,4);
        var removeDuplicates = numbers14.stream().distinct().toList();
        System.out.println(removeDuplicates);

        //Task 30
        List<Integer> numbers15 = List.of(1,2,3);
        var convertToStringList = numbers15.stream().map(Object::toString).toList();
        System.out.println(convertToStringList);

        //Task 31
        List<String> words2 = List.of("A","B","C");
        String comma = words2.stream().collect(Collectors.joining(","));
        System.out.println(comma);

        //Task 32
        List<Integer> numbers16 = List.of(1,2,3,4);
        var sum = numbers16.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //Task 33
        List<String> items = List.of("pen","pencil","eraser");
        var count = items.stream().count();
        System.out.println(count);

        //Task 34
        List<String> list2 = List.of();
        var checkIsEmpty = list2.stream().allMatch(x -> x.isEmpty());
        System.out.println(checkIsEmpty);

        //Task 35
        List<String> names5 = List.of("A","B","A");
        var convertToSet = names5.stream().collect(Collectors.toSet());
        System.out.println(convertToSet);
    }
}
