package egger.software.an_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String s : list) {
            if (s.equals("1")) {
                // list.remove(s); // throw ConcurrentModificationException
            }
        }

        Iterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("1")) {
                it.remove();
            }
        }
        list.forEach(System.out::println);

        ListIterator<String> listIt = list.listIterator();
        while (listIt.hasNext()) {
            int index = listIt.nextIndex();
            String s = listIt.next();
            System.out.println(index + " - " + s);
        }
    }
}
