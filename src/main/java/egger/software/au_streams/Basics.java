package egger.software.au_streams;


import java.util.Arrays;
import java.util.List;

public class Basics {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,4,5,6,7);

        //matching
        System.out.println("All elements < 5: " +
                list.stream().allMatch(entry -> entry < 5));
        System.out.println("Any element < 5: " +
                list.stream().anyMatch(entry -> entry < 5));

        //select elements
        list.stream().skip(1).limit(3).forEach(Basics::printElement);
        System.out.println();

        //map
        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");
        System.out.println("Map to int and sum: " +
                stringList.stream().mapToInt(entry -> Integer.parseInt(entry)).sum());

        //reduce
        System.out.println("Multiply all values: " +
                list.stream().reduce((intermediate,current) -> intermediate + current).get());

        //filter
        list.stream().filter(entry -> entry < 5).forEach(Basics::printElement);
        System.out.println();

        //find
        System.out.println("Any entry == 5: " +
            list.stream().filter(entry -> entry == 5).findAny().get());

        //sort
        List<Integer> unsortedList = Arrays.asList(3,7,4,6,5);
        unsortedList.stream().sorted((lhs, rhs) -> -1 * lhs.compareTo(rhs)).forEach(Basics::printElement);
        System.out.println();

    }

    private static void printElement(Integer element) {
        System.out.print(element + ", ");
    }
}
