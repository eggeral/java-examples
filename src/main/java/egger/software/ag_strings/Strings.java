package egger.software.ag_strings;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strings {

    public static void main(String[] args) {
        String test = "1," +  "2"; // + Operator is overloaded (Only for Strings!)

        if ("test" == "test") //never compare Strings with ==
            System.out.println("equal");

        if ("test" != new String("test"))
            System.out.println("not equal");

        if ("test".equals(new String("test")))
            System.out.println("equal");

        System.out.println(String.format("%.2f", 6.567));

        StringBuffer buffer = new StringBuffer(); //old but thread safe
        buffer.append("test").append(1);
        System.out.println(buffer.toString());

        StringBuilder builder = new StringBuilder(); //new not thread safe
        builder.append("test").append(2);
        System.out.println(builder.toString());

        System.out.println(Stream.of("1,2,3".split(",")).collect(Collectors.joining(",")));
    }
}
