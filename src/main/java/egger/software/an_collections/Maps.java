package egger.software.an_collections;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Maps {

    enum Color {red, green};

    public static void main(String[] args) {

        // default map
        Map<Integer, String> hashMap = new HashMap();
        hashMap.put(1, "test1");
        hashMap.put(2, "test2");
        hashMap.put(3, "test3");

        hashMap.entrySet().forEach(System.out::println);

        hashMap.putIfAbsent(4, "test4");
        hashMap.putIfAbsent(4, "test5");

        hashMap.entrySet().forEach(System.out::println);

        hashMap.compute(5, (key, oldValue) -> "test5 " + oldValue);

        hashMap.entrySet().forEach(System.out::println);

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.getOrDefault(10, "default"));
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsValue("test"));


        hashMap.replace(1, "test1 1");
        hashMap.remove(2);
        hashMap.entrySet().forEach(System.out::println);

        Map<Integer, String> targetMap = new HashMap<>();
        hashMap.forEach((key, value) -> targetMap.put(key * 10, value + " - " + value));
        targetMap.entrySet().forEach(System.out::println);

        WeakHashMap<String, String> weekHashMap = new WeakHashMap<>(); // Useful for caches. Key are garbage collected.
        EnumMap<Color, String> enumHashMap = new EnumMap<>(Color.class);
        // ...


    }

}
