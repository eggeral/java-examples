package egger.software.an_collections;

import java.util.*;

public class Tools {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        // list.remove(1); //not supported

        List<String> l = new ArrayList<>();
        Collections.addAll(l, "1", "2", "3");
        l.forEach(System.out::println);

        List<String> emptyStringList = Collections.emptyList();
        // emptyStringList.add("test"); //not supported

        Collections.reverse(l);
        l.forEach(System.out::println);

        List objectList = l;
        objectList.add(1);
        List<String> checkedList = Collections.checkedList(l, String.class);
        objectList = checkedList;
        // objectList.add(2); //throws an exception

        List<String> synchronizedList = Collections.synchronizedList(l);

        List<String> unmodifyAbleList = Collections.unmodifiableList(l);
        //unmodifyAbleList.add("2"); // not supported

        List<String> sortMe = new ArrayList<>();
        Collections.addAll(sortMe, "A", "Z", "a", "d", "R");
        Collections.sort(sortMe);
        sortMe.forEach(System.out::println);
        Collections.sort(sortMe, (o1, o2) -> o1.compareToIgnoreCase(o2));
        sortMe.forEach(System.out::println);
    }
}
