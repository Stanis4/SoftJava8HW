/*Given a list of Strings, write a method that returns a list
of all strings that start with the letter 'a' (lower case)
and have exactly 3 letters.*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringMethods {
    private static final Logger logger = LogManager.getLogger(StringMethods.class);

    public static void main(String[] args) {
        List<String> names = Arrays.asList("abcd", "Abc", "aBcd", "abc", "aab");
        logger.info("Task 1: The list of Strings is given: \n" + names);
        logger.info("The list of names that start with the letter 'a'" +
                " and no longer than 3 symbols \n" + filterList(names));

        List<Integer> numbers = Arrays.asList(3, 44, 1, 15, 17, 124);
        logger.info("Task2: The list of numbers: \n "+ numbers);
        logger.info("The list of sorted numbers: \n"+ numberList(numbers));

        List<Integer> nums = Arrays.asList(-15, 25, 188, 456, -200, 320, 50, -51);
        logger.info("Task 3: The list of numbers is given: \n"+ nums);
        logger.info("The amount of numbers which ON MODULE are more than 50 is "+ countNumbers(nums));

    }

    //first task
    private static  List<String> filterList(List<String> names){
        return names.stream()
                .filter(name -> name.startsWith("a"))
                .filter(length -> length.length() == 3)
                .collect(Collectors.toList());
    }

    //second task
    private static String numberList(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> (num % 2) == 0 ? "e" + num : "o" + num).
                collect(Collectors.joining(", "));
    }

    //third task
    private static long countNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> Math.abs(number)>50)
                .count();
    }
}