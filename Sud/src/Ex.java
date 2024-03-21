import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

        //Excercise 1:
        System.out.println("\nExcercise 1: \n" + evenNumbers(numbers));
        //List<Integer> expectedOutput = Arrays.asList(-2, -4, -8, 12, 6, 10, 14);

        //Excercise 2:
        System.out.println("\nExcercise 2: \n" + positivNumbersOnPower(numbers));
        //List<Integer> expectedOutput = Arrays.asList(1, 9, 144, 361, 36, 81, 100, 196);

        //Excercise 3:
        List<Integer> numbers1 = Arrays.asList(3, 9, 2, 8, 6, 5);
        System.out.println("\nExcercise 3: \n" + listOfNumbersPowerIsMoreThan(numbers1,20));
        //List<Integer> expectedOutput = Arrays.asList(9, 8, 6, 5);

        //Excercise 4:
        List<Integer> numbers2 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        System.out.println("\nExcercise 4: \n" + averageOfOddNumbers(numbers2) + "/" + countOddNumbers(numbers2));
        //double expectedOutput = 22.0/6.0;

        //Excercise 5:
        List<Integer> numbers3 = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
        System.out.println("\nExcercise 5: \n" + sumOfOddNumbers(numbers3));
        //int expectedOutput = 61;

        //Excercise 6:
        String s = "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Morbi nec mattis odio.";
        //System.out.println("\nExcercise 6: \n" + listOfUppercaseCharacters(s));
        //List<Character> expectedOutput = Arrays.asList('L', 'I', 'D', 'S', 'A', 'C', 'A', 'E', 'M');

        //Excercise 7:
        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
        System.out.println("\nExcercise 7: \n" + stringsStartsWith(cities,'R'));
        System.out.println(stringsStartsWith(cities,'N'));
        //List<String> expectedOutput;
        //expectedOutput = Arrays.asList("ROME"); // for 'R'
        //expectedOutput = Arrays.asList("NAIROBI", "NEW DELHI"); // for 'N'

        //Excercise 8:
        List<Character> characters = Arrays.asList('L', 'o', 'r', 'e', 'm', ' ', 'i', 'p', 's', 'u', 'm');
        System.out.println("\nExcercise 8: \n" + concatenateCharacters(characters));
        //String expectedOutput = "Lorem ipsum";

        //Excercise 9:
        //String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.";
        //System.out.println("\nExcercise 9: \n" + frequencyOfCharacters(s));
        //{ =12, a=2, c=4, d=7, e=8, g=1, i=10, l=2, ,=2, L=1, m=5, n=4, .=1, o=7, p=3, r=4, s=6, t=7, u=4}
    }

    //private static HashMap<String,Integer> frequencyOfCharacters(String s) {
    //    return Collections.
    //}

    private static String concatenateCharacters(List<Character> characters) {
        return characters
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static List<String> stringsStartsWith(List<String> cities, Character r) {
        return cities
                .stream()
                .filter(x-> x.startsWith(r.toString()))
                .collect(Collectors.toList());
    }

    //private static List<Character> listOfUppercaseCharacters(String s) {
    //    char[] ch = s.toCharArray();
    //    return
    //}

    private static int sumOfOddNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(x->x % 2 != 0)
                .reduce(Integer::sum)
                .get();
    }

    private static double averageOfOddNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(x->x % 2 != 0)
                .reduce(Integer::sum)
                .get();
    }

    private static List<Integer> listOfNumbersPowerIsMoreThan(List<Integer> numbers, int number) {
        return numbers
                .stream()
                .filter(x->(x * x > number))
                .collect(Collectors.toList());
    }

    private static List<Integer> evenNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(x->x % 2 == 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> positivNumbersOnPower(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(x->x > 0)
                .map(x->x * x)
                .collect(Collectors.toList());
    }

    private static double countOddNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(x->x % 2 != 0)
                .count();

    }
}