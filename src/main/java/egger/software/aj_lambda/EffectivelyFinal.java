package egger.software.aj_lambda;

import java.util.Arrays;

public class EffectivelyFinal {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        b = 25;

        Arrays.asList(1, 2, 3, 4).forEach((n) -> System.out.println(n + " - " + a));
        //Arrays.asList(1, 2, 3, 4).forEach((n) -> System.out.println(n + " - " + b));
    }
}
