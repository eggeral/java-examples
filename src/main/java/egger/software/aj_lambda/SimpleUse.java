package egger.software.aj_lambda;

import java.util.Arrays;
import java.util.List;

public class SimpleUse {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1", "a2", "a3");

        for (String s : list) {
            System.out.println(s);
        }

        list.forEach(s -> System.out.println(s));

        list.forEach(SimpleUse::print);

        list.forEach(System.out::println);
    }

    private static void print(String s) {
        System.out.println(s);
    }

}
