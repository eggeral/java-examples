package egger.software.an_collections;

import java.util.*;

public class Maps {

    enum Color {red, green}

    ;

    public static void main(String[] args) {

        // default map
        Map<Integer, String> hashMap = new HashMap();
        hashMap.put(1, "test1");
        hashMap.put(2, "test2");
        hashMap.put(3, "test3");
        hashMap.put(3, "test4");

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

        // implement hashCode and equals
        System.out.println("-- hashCode and equals");
        System.out.println();

        Map<WrongHashClass, Integer> wrongHashCodeTest = new HashMap<>();
        wrongHashCodeTest.put(new WrongHashClass(1,"a"), 1);
        wrongHashCodeTest.put(new WrongHashClass(1,"a"), 2);
        wrongHashCodeTest.entrySet().forEach(System.out::println);

        System.out.println("--");

        Map<CorrectHashClass, Integer> correctHashCodeTest = new HashMap<>();
        correctHashCodeTest.put(new CorrectHashClass(1,"a"), 1);
        correctHashCodeTest.put(new CorrectHashClass(1,"a"), 2);
        correctHashCodeTest.entrySet().forEach(System.out::println);

    }

    public static class WrongHashClass {

        private Random rnd = new Random();

        private final int a;
        private final String b;

        public WrongHashClass(int a, String b) {
            this.a = a;
            this.b = b;
        }

        // equals always means same hash code!
        // same hash code does not automatically mean equals!


        @Override
        public int hashCode() {
            return rnd.nextInt();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WrongHashClass that = (WrongHashClass) o;

            if (a != that.a) return false;
            return b != null ? b.equals(that.b) : that.b == null;
        }

        @Override
        public String toString() {
            return "RandomHashClass{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    '}';
        }
    }

    public static class CorrectHashClass {

        private final int a;
        private final String b;

        public CorrectHashClass(int a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + (b != null ? b.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CorrectHashClass that = (CorrectHashClass) o;

            if (a != that.a) return false;
            return b != null ? b.equals(that.b) : that.b == null;
        }

        @Override
        public String toString() {
            return "CorrectHashClass{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    '}';
        }
    }

}
