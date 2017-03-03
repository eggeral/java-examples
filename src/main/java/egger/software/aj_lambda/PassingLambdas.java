package egger.software.aj_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PassingLambdas {
    public static void main(String[] args) {
        List<String> result = filter(
                Arrays.asList("a", "aa", "aaa", "a", "aa", "aaa"),
                s -> s.length() == 2);
        result.forEach(System.out::println);
    }

    private static List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s))
                result.add(s);
        }
        return result;
    }

}
