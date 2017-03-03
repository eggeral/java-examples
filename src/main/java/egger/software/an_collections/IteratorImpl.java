package egger.software.an_collections;

import java.util.*;

public class IteratorImpl {
    public static class FixedList<TValue> implements Iterable<TValue> {
        private TValue[] values;

        public FixedList(TValue[] values) {

            this.values = values;
        }

        @Override
        public Iterator<TValue> iterator() {
            return new Iterator<TValue>() {
                int index = -1;

                @Override
                public boolean hasNext() {
                    return index < values.length - 1;
                }

                @Override
                public TValue next() {
                    index++;
                    return values[index];
                }
            };
        }
    }

    public static void main(String[] args) {
        FixedList<String> list = new FixedList<>(new String[] { "1", "2", "3" });

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

    }
}
