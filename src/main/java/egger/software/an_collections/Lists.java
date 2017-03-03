package egger.software.an_collections;

import java.util.*;

public class Lists {
    public static void main(String[] args) {
        //default list
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add(1,"3");
        arrayList.set(0, "n1");

        arrayList.forEach(System.out::println);

        System.out.println("size: " + arrayList.size());
        System.out.println("get: " + arrayList.get(1));
        System.out.println("contains: "+ arrayList.contains("2"));
        System.out.println("remove: "+ arrayList.remove(1)); //attention ConcurrentModificationException ahead

        arrayList.forEach(System.out::println);
        arrayList.subList(1,2).forEach(System.out::println);

        //old thread save default list
        List<String> vector = new Vector<>();

        //efficient get of first and last
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(arrayList);

        linkedList.forEach(System.out::println);

        System.out.println("first: " + linkedList.getFirst());
        System.out.println("last:" + linkedList.getLast());

        //a linked list is also a deque
        Deque<String> deque = linkedList;
        System.out.println("poll: " + deque.poll());

        deque.forEach(System.out::println);
    }
}
