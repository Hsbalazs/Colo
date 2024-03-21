import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        System.out.println("\nExcercise 6: \n" + listOfUppercaseCharacters(s));
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
        String s1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.";
        System.out.println("\nExcercise 9: \n" + frequencyOfCharacters(s1));
        //{ =12, a=2, c=4, d=7, e=8, g=1, i=10, l=2, ,=2, L=1, m=5, n=4, .=1, o=7, p=3, r=4, s=6, t=7, u=4}

        //Excercise 10:
        List<Fox> foxes = new ArrayList<>();
        foxes.add(new Fox("Bucky",10,"red"));
        foxes.add(new Fox("Chuky",9,"green"));
        foxes.add(new Fox("Hulk",3,"yellow"));
        foxes.add(new Fox("Rusty",5,"black"));
        foxes.add(new Fox("Rudy",6,"green"));
        foxes.add(new Fox("Gaby",10,"red"));
        foxes.add(new Fox("Trench",4,"green"));
        foxes.add(new Fox("Ready",7,"blue"));

        System.out.println("\nExcercise 10: \n" + greenColoredFoxes(foxes));
        System.out.println(greenColoredFoxesYoungerThan5(foxes));
        System.out.println(frequencyOfFoxesByColor(foxes));
        //System.out.println("\nExcercise 10: \n" + frequencyOfColors(foxes));

        //Create a Fox class with 3 properties: name, color and age.
        //Create a list of foxes and add at least 8 instances to it. Then, using the Stream API

        //write a method to return a list of foxes of green color
        //[Fox[4, GREEN, Skuld], Fox[9, GREEN, Hildr]]
        //write a method to return a list of foxes of green color younger than 5
        //        [Fox[4, GREEN, Skuld]]
        //write a method to return a map specifying the frequency of foxes by color
        //{GREEN=2, WHITE=1, BLACK=1, GRAY=1, RED=3}
    }

    private static Map<String,Long> frequencyOfFoxesByColor(List<Fox> foxes) {
        return foxes
                .stream()
                .map(f-> f.color)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static List<Fox> greenColoredFoxesYoungerThan5(List<Fox> foxes) {
        return foxes
                .stream()
                .filter(x->x.color == "green" && x.age < 5)
                .collect(Collectors.toList());
    }

    private static List<Fox> greenColoredFoxes(List<Fox> foxes) {
        return foxes
                .stream()
                .filter(x->x.color == "green")
                .collect(Collectors.toList());
    }


    private static Map<Character,Long> frequencyOfCharacters(String s) {
        return s
                .chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

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

    private static List<Character> listOfUppercaseCharacters(String s) {
        return s
                .chars()
                .mapToObj(c-> (char) c)
                .filter(Character::isUpperCase)
                .collect(Collectors.toList());
    }

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